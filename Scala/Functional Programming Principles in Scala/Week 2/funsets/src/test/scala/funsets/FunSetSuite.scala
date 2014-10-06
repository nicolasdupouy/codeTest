package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {

  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   *
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   *
   *   val s1 = singletonSet(1)
   *
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   *
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   *
   */

  trait TestSets {
    val s0 = singletonSet(0)
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val s4 = singletonSet(4)
    val s5 = singletonSet(5)
    val s7 = singletonSet(7)
    val s1000 = singletonSet(1000)
    val sMoins1000 = singletonSet(-1000)

    // [2, 3]
    val s23 = union(s2, s3)

    // [1, 3, 4, 5, 7, 1000]
    val s13 = union(s1, s3)
    val s45 = union(s4, s5)
    val s1345 = union(s13, s45)
    val s7_1000 = union(s7, s1000)
    val s13457_1000 = union(s1345, s7_1000)

    // [1, 2, 3, 4]
    val s12 = union(s1, s2)
    val s34 = union(s3, s4)
    val s1234 = union(s12, s34)

    // [-1000, 0]
    val sMoins1000_0 = union(sMoins1000, s0)
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   *
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {

    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3".
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val sUnion = union(s1, s2)
      assert(contains(sUnion, 1), "Union 1")
      assert(contains(sUnion, 2), "Union 2")
      assert(!contains(sUnion, 3), "Union 3")
    }
  }

  test("intersect contains the elements at the intersection") {
    new TestSets {
      val sInter = intersect(s12, s23)

      assert(!contains(sInter, 1), "Intersection 1")
      assert(contains(sInter, 2), "Intersection 2")
      assert(!contains(sInter, 3), "Intersection 3")
    }
  }

  test("diff between {1,3,4,5,7,1000} and {1,2,3,4}  gives {[5,7],1000}") {
    new TestSets {

      val sDiff = diff(s13457_1000, s1234)

      assert(contains(sDiff, 5), "Difference 5")
      assert(contains(sDiff, 7), "Difference 7")
      assert(contains(sDiff, 1000), "Difference 1000")

      assert(!contains(sDiff, 2), "Difference 2")
      assert(!contains(sDiff, 3), "Difference 3")
    }
  }

  test("diff between {1,2,3,4} and {-1000,0} gives {1,2,3,4}") {
    new TestSets {
      val sDiff = diff(s1234, sMoins1000_0)

      assert(contains(sDiff, 1), "Difference 1")
      assert(contains(sDiff, 2), "Difference 2")
      assert(contains(sDiff, 3), "Difference 3")
      assert(contains(sDiff, 4), "Difference 4")

      assert(!contains(sDiff, -1000), "Difference -1000")
      assert(!contains(sDiff, 0), "Difference 0")
    }
  }

  test("filtering") {
    new TestSets {
      val sUnion = union(s12, s23)

      val sUnionFiltered2 = filter(sUnion, x => x <= 2)
      val sUnionFiltered3 = filter(sUnion, x => x <= 3)

      assert(contains(sUnionFiltered2, 1), "Filter >2 contains 1")
      assert(contains(sUnionFiltered2, 2), "Filter >2 contains 2")
      assert(!contains(sUnionFiltered2, 3), "Filter >2 contains 2")
      assert(contains(sUnionFiltered3, 3), "Filter >3 contains 3")
    }
  }

  test("forall: {1,3,4,5,7,1000}") {
    new TestSets {
      assert(forall(s13457_1000, x => x < 5) == false, "All elements in the set are strictly less than 5")
      assert(forall(s13457_1000, x => x <= 999) == false, "All elements in the set are less or equal to 999")
      assert(forall(s13457_1000, x => x <= 1000) == true, "All elements in the set are less or equal to 1000")
    }
  }

  test("exists: given {1,2,3,4}") {
    new TestSets {
      // => 2 should exist in the given set.
      assert(exists(s1234, x => x == 1) == true, "1 should exists in the given set.")
      assert(exists(s1234, x => x == 2) == true, "2 should exists in the given set.")
      assert(exists(s1234, x => x == 3) == true, "3 should exists in the given set.")
      assert(exists(s1234, x => x == 4) == true, "4 should exists in the given set.")
      assert(exists(s1234, x => x == 8) == false, "8 should not exists in the given set.")
    }
  }

  // exists & filter: even and 3
  // => The set of all even numbers and 3 should contain an odd element, namely 3.

  // map: {1,3,4,5,7,1000}

  // forall & map: doubling numbers

}
