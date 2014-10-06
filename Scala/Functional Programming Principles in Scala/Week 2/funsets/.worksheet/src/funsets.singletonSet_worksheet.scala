package funsets

object singletonSet_worksheet {
  import FunSets._;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(95); 

  val s0 = singletonSet(0);System.out.println("""s0  : funsets.FunSets.Set = """ + $show(s0 ));$skip(27); 
  val s1 = singletonSet(1);System.out.println("""s1  : funsets.FunSets.Set = """ + $show(s1 ));$skip(27); 
  val s2 = singletonSet(2);System.out.println("""s2  : funsets.FunSets.Set = """ + $show(s2 ));$skip(27); 
  val s3 = singletonSet(3);System.out.println("""s3  : funsets.FunSets.Set = """ + $show(s3 ));$skip(27); 
  val s4 = singletonSet(4);System.out.println("""s4  : funsets.FunSets.Set = """ + $show(s4 ));$skip(27); 
  val s5 = singletonSet(5);System.out.println("""s5  : funsets.FunSets.Set = """ + $show(s5 ));$skip(27); 
  val s7 = singletonSet(7);System.out.println("""s7  : funsets.FunSets.Set = """ + $show(s7 ));$skip(33); 
  val s1000 = singletonSet(1000);System.out.println("""s1000  : funsets.FunSets.Set = """ + $show(s1000 ));$skip(39); 
  val sMoins1000 = singletonSet(-1000);System.out.println("""sMoins1000  : funsets.FunSets.Set = """ + $show(sMoins1000 ));$skip(39); 

  // [2, 3]
  val s23 = union(s2, s3);System.out.println("""s23  : funsets.FunSets.Set = """ + $show(s23 ));$skip(54); 

  // [1, 3, 4, 5, 7, 1000]
  val s13 = union(s1, s3);System.out.println("""s13  : funsets.FunSets.Set = """ + $show(s13 ));$skip(26); 
  val s45 = union(s4, s5);System.out.println("""s45  : funsets.FunSets.Set = """ + $show(s45 ));$skip(30); 
  val s1345 = union(s13, s45);System.out.println("""s1345  : funsets.FunSets.Set = """ + $show(s1345 ));$skip(33); 
  val s7_1000 = union(s7, s1000);System.out.println("""s7_1000  : funsets.FunSets.Set = """ + $show(s7_1000 ));$skip(42); 
  val s13457_1000 = union(s1345, s7_1000);System.out.println("""s13457_1000  : funsets.FunSets.Set = """ + $show(s13457_1000 ));$skip(45); 

  // [1, 2, 3, 4]
  val s12 = union(s1, s2);System.out.println("""s12  : funsets.FunSets.Set = """ + $show(s12 ));$skip(26); 
  val s34 = union(s3, s4);System.out.println("""s34  : funsets.FunSets.Set = """ + $show(s34 ));$skip(30); 
  val s1234 = union(s12, s34);System.out.println("""s1234  : funsets.FunSets.Set = """ + $show(s1234 ));$skip(60); 

  // [-1000, 0]
  val sMoins1000_0 = union(sMoins1000, s0);System.out.println("""sMoins1000_0  : funsets.FunSets.Set = """ + $show(sMoins1000_0 ));$skip(19); val res$0 = 

  contains(s1, 1);System.out.println("""res0: Boolean = """ + $show(res$0));$skip(18); val res$1 = 
  contains(s1, 3);System.out.println("""res1: Boolean = """ + $show(res$1));$skip(28); 

  println(contains(s2, 1));$skip(40); 

  val sDiff = diff(s13457_1000, s1234);System.out.println("""sDiff  : funsets.FunSets.Set = """ + $show(sDiff ));$skip(25); 

  printSet(s13457_1000);$skip(18); 
  printSet(s1234);$skip(18); 
  printSet(sDiff);$skip(35); val res$2 = 

  forall(s13457_1000, x => x < 5);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(37); val res$3 = 
  forall(s13457_1000, x => x <= 999);System.out.println("""res3: Boolean = """ + $show(res$3));$skip(38); val res$4 = 
  forall(s13457_1000, x => x <= 1000);System.out.println("""res4: Boolean = """ + $show(res$4));$skip(30); val res$5 = 

  exists(s1234, x => x == 2);System.out.println("""res5: Boolean = """ + $show(res$5));$skip(29); val res$6 = 
  exists(s1234, x => x == 3);System.out.println("""res6: Boolean = """ + $show(res$6));$skip(29); val res$7 = 
  exists(s1234, x => x == 8);System.out.println("""res7: Boolean = """ + $show(res$7));$skip(42); 

  printSet(map(s13457_1000, x => x * x))}
}
