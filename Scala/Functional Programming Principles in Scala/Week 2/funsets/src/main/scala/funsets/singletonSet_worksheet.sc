package funsets

object singletonSet_worksheet {
  import FunSets._

  val s0 = singletonSet(0)                        //> s0  : funsets.FunSets.Set = <function1>
  val s1 = singletonSet(1)                        //> s1  : funsets.FunSets.Set = <function1>
  val s2 = singletonSet(2)                        //> s2  : funsets.FunSets.Set = <function1>
  val s3 = singletonSet(3)                        //> s3  : funsets.FunSets.Set = <function1>
  val s4 = singletonSet(4)                        //> s4  : funsets.FunSets.Set = <function1>
  val s5 = singletonSet(5)                        //> s5  : funsets.FunSets.Set = <function1>
  val s7 = singletonSet(7)                        //> s7  : funsets.FunSets.Set = <function1>
  val s1000 = singletonSet(1000)                  //> s1000  : funsets.FunSets.Set = <function1>
  val sMoins1000 = singletonSet(-1000)            //> sMoins1000  : funsets.FunSets.Set = <function1>

  // [2, 3]
  val s23 = union(s2, s3)                         //> s23  : funsets.FunSets.Set = <function1>

  // [1, 3, 4, 5, 7, 1000]
  val s13 = union(s1, s3)                         //> s13  : funsets.FunSets.Set = <function1>
  val s45 = union(s4, s5)                         //> s45  : funsets.FunSets.Set = <function1>
  val s1345 = union(s13, s45)                     //> s1345  : funsets.FunSets.Set = <function1>
  val s7_1000 = union(s7, s1000)                  //> s7_1000  : funsets.FunSets.Set = <function1>
  val s13457_1000 = union(s1345, s7_1000)         //> s13457_1000  : funsets.FunSets.Set = <function1>

  // [1, 2, 3, 4]
  val s12 = union(s1, s2)                         //> s12  : funsets.FunSets.Set = <function1>
  val s34 = union(s3, s4)                         //> s34  : funsets.FunSets.Set = <function1>
  val s1234 = union(s12, s34)                     //> s1234  : funsets.FunSets.Set = <function1>

  // [-1000, 0]
  val sMoins1000_0 = union(sMoins1000, s0)        //> sMoins1000_0  : funsets.FunSets.Set = <function1>

  contains(s1, 1)                                 //> res0: Boolean = true
  contains(s1, 3)                                 //> res1: Boolean = false

  println(contains(s2, 1))                        //> false

  val sDiff = diff(s13457_1000, s1234)            //> sDiff  : funsets.FunSets.Set = <function1>

  printSet(s13457_1000)                           //> {1,3,4,5,7,1000}
  printSet(s1234)                                 //> {1,2,3,4}
  printSet(sDiff)                                 //> {5,7,1000}

  forall(s13457_1000, x => x < 5)                 //> res2: Boolean = false
  forall(s13457_1000, x => x <= 999)              //> res3: Boolean = false
  forall(s13457_1000, x => x <= 1000)             //> res4: Boolean = true

  exists(s1234, x => x == 2)                      //> res5: Boolean = true
  exists(s1234, x => x == 3)                      //> res6: Boolean = true
  exists(s1234, x => x == 8)                      //> res7: Boolean = false

  printSet(map(s13457_1000, x => x * x))          //> {1,9,16,25,49}
}