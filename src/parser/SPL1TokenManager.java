/* SPL1TokenManager.java */
/* Generated By:JavaCC: Do not edit this line. SPL1TokenManager.java */
package parser;
import memory.*;
import program.Program;
import command.*;
import declarations.*;
import formulas.*;
import types.*;
import util.*;
import java.util.List;
import java.util.ArrayList;

/** Token Manager. */
@SuppressWarnings ("unused")
public class SPL1TokenManager implements SPL1Constants {

  /** Debug output. */
  public static  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public static  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private static final int jjStopStringLiteralDfa_0(int pos, long active0){
   switch (pos)
   {
      case 0:
         if ((active0 & 0x3dffff000L) != 0L)
         {
            jjmatchedKind = 34;
            return 1;
         }
         return -1;
      case 1:
         if ((active0 & 0x100409000L) != 0L)
            return 1;
         if ((active0 & 0x2dfbf6000L) != 0L)
         {
            jjmatchedKind = 34;
            jjmatchedPos = 1;
            return 1;
         }
         return -1;
      case 2:
         if ((active0 & 0x280000000L) != 0L)
            return 1;
         if ((active0 & 0x5fbf6000L) != 0L)
         {
            jjmatchedKind = 34;
            jjmatchedPos = 2;
            return 1;
         }
         return -1;
      case 3:
         if ((active0 & 0x6840000L) != 0L)
            return 1;
         if ((active0 & 0x593b6000L) != 0L)
         {
            jjmatchedKind = 34;
            jjmatchedPos = 3;
            return 1;
         }
         return -1;
      case 4:
         if ((active0 & 0x1000000L) != 0L)
            return 1;
         if ((active0 & 0x483b6000L) != 0L)
         {
            jjmatchedKind = 34;
            jjmatchedPos = 4;
            return 1;
         }
         return -1;
      case 5:
         if ((active0 & 0x483b6000L) != 0L)
         {
            jjmatchedKind = 34;
            jjmatchedPos = 5;
            return 1;
         }
         return -1;
      case 6:
         if ((active0 & 0x8382000L) != 0L)
         {
            jjmatchedKind = 34;
            jjmatchedPos = 6;
            return 1;
         }
         if ((active0 & 0x40034000L) != 0L)
            return 1;
         return -1;
      case 7:
         if ((active0 & 0x282000L) != 0L)
         {
            jjmatchedKind = 34;
            jjmatchedPos = 7;
            return 1;
         }
         if ((active0 & 0x8100000L) != 0L)
            return 1;
         return -1;
      case 8:
         if ((active0 & 0x202000L) != 0L)
         {
            jjmatchedKind = 34;
            jjmatchedPos = 8;
            return 1;
         }
         if ((active0 & 0x80000L) != 0L)
            return 1;
         return -1;
      case 9:
         if ((active0 & 0x202000L) != 0L)
         {
            jjmatchedKind = 34;
            jjmatchedPos = 9;
            return 1;
         }
         return -1;
      default :
         return -1;
   }
}
private static final int jjStartNfa_0(int pos, long active0){
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
static private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
static private int jjMoveStringLiteralDfa0_0(){
   switch(curChar)
   {
      case 40:
         return jjStopAtPos(0, 6);
      case 41:
         return jjStopAtPos(0, 7);
      case 44:
         return jjStopAtPos(0, 11);
      case 59:
         return jjStopAtPos(0, 10);
      case 61:
         return jjStopAtPos(0, 29);
      case 65:
         return jjMoveStringLiteralDfa1_0(0x200000L);
      case 70:
         return jjMoveStringLiteralDfa1_0(0x12000L);
      case 77:
         return jjMoveStringLiteralDfa1_0(0x80000L);
      case 79:
         return jjMoveStringLiteralDfa1_0(0x500000L);
      case 80:
         return jjMoveStringLiteralDfa1_0(0x21000L);
      case 82:
         return jjMoveStringLiteralDfa1_0(0x40000L);
      case 97:
         return jjMoveStringLiteralDfa1_0(0x82008000L);
      case 99:
         return jjMoveStringLiteralDfa1_0(0x8000000L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x4000L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x40000000L);
      case 110:
         return jjMoveStringLiteralDfa1_0(0x200000000L);
      case 111:
         return jjMoveStringLiteralDfa1_0(0x100800000L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0x5000000L);
      case 116:
         return jjMoveStringLiteralDfa1_0(0x10000000L);
      case 123:
         return jjStopAtPos(0, 8);
      case 125:
         return jjStopAtPos(0, 9);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
static private int jjMoveStringLiteralDfa1_0(long active0){
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 65:
         return jjMoveStringLiteralDfa2_0(active0, 0x80000L);
      case 76:
         if ((active0 & 0x1000L) != 0L)
            return jjStartNfaWithStates_0(1, 12, 1);
         return jjMoveStringLiteralDfa2_0(active0, 0x200000L);
      case 79:
         return jjMoveStringLiteralDfa2_0(active0, 0x40000L);
      case 80:
         return jjMoveStringLiteralDfa2_0(active0, 0x100000L);
      case 82:
         if ((active0 & 0x400000L) != 0L)
            return jjStartNfaWithStates_0(1, 22, 1);
         break;
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x10002000L);
      case 102:
         return jjMoveStringLiteralDfa2_0(active0, 0x800000L);
      case 105:
         return jjMoveStringLiteralDfa2_0(active0, 0x6000000L);
      case 109:
         return jjMoveStringLiteralDfa2_0(active0, 0x40000000L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x80000000L);
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x209010000L);
      case 114:
         if ((active0 & 0x100000000L) != 0L)
            return jjStartNfaWithStates_0(1, 32, 1);
         return jjMoveStringLiteralDfa2_0(active0, 0x20000L);
      case 115:
         if ((active0 & 0x8000L) != 0L)
            return jjStartNfaWithStates_0(1, 15, 1);
         break;
      case 120:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
static private int jjMoveStringLiteralDfa2_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 78:
         return jjMoveStringLiteralDfa3_0(active0, 0x80000L);
      case 79:
         return jjMoveStringLiteralDfa3_0(active0, 0x40000L);
      case 84:
         return jjMoveStringLiteralDfa3_0(active0, 0x300000L);
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x2000L);
      case 100:
         if ((active0 & 0x80000000L) != 0L)
            return jjStartNfaWithStates_0(2, 31, 1);
         break;
      case 102:
         return jjMoveStringLiteralDfa3_0(active0, 0x3000000L);
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x820000L);
      case 112:
         return jjMoveStringLiteralDfa3_0(active0, 0x40000000L);
      case 114:
         return jjMoveStringLiteralDfa3_0(active0, 0x10000L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x10000000L);
      case 116:
         if ((active0 & 0x200000000L) != 0L)
            return jjStartNfaWithStates_0(2, 33, 1);
         return jjMoveStringLiteralDfa3_0(active0, 0x4000L);
      case 118:
         return jjMoveStringLiteralDfa3_0(active0, 0x8000000L);
      case 122:
         return jjMoveStringLiteralDfa3_0(active0, 0x4000000L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
static private int jjMoveStringLiteralDfa3_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 68:
         return jjMoveStringLiteralDfa4_0(active0, 0x80000L);
      case 69:
         return jjMoveStringLiteralDfa4_0(active0, 0x200000L);
      case 73:
         return jjMoveStringLiteralDfa4_0(active0, 0x100000L);
      case 84:
         if ((active0 & 0x40000L) != 0L)
            return jjStartNfaWithStates_0(3, 18, 1);
         break;
      case 100:
         return jjMoveStringLiteralDfa4_0(active0, 0x20000L);
      case 101:
         if ((active0 & 0x4000000L) != 0L)
            return jjStartNfaWithStates_0(3, 26, 1);
         return jjMoveStringLiteralDfa4_0(active0, 0x8004000L);
      case 108:
         if ((active0 & 0x2000000L) != 0L)
            return jjStartNfaWithStates_0(3, 25, 1);
         return jjMoveStringLiteralDfa4_0(active0, 0x40000000L);
      case 109:
         return jjMoveStringLiteralDfa4_0(active0, 0x10000L);
      case 111:
         return jjMoveStringLiteralDfa4_0(active0, 0x1000000L);
      case 116:
         if ((active0 & 0x800000L) != 0L)
            return jjStartNfaWithStates_0(3, 23, 1);
         return jjMoveStringLiteralDfa4_0(active0, 0x10002000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
static private int jjMoveStringLiteralDfa4_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 63:
         if ((active0 & 0x10000000L) != 0L)
            return jjStopAtPos(4, 28);
         break;
      case 65:
         return jjMoveStringLiteralDfa5_0(active0, 0x80000L);
      case 79:
         return jjMoveStringLiteralDfa5_0(active0, 0x100000L);
      case 82:
         return jjMoveStringLiteralDfa5_0(active0, 0x200000L);
      case 105:
         return jjMoveStringLiteralDfa5_0(active0, 0x40000000L);
      case 110:
         return jjMoveStringLiteralDfa5_0(active0, 0x4000L);
      case 114:
         return jjMoveStringLiteralDfa5_0(active0, 0x8000000L);
      case 116:
         if ((active0 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_0(4, 24, 1);
         break;
      case 117:
         return jjMoveStringLiteralDfa5_0(active0, 0x32000L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
static private int jjMoveStringLiteralDfa5_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 78:
         return jjMoveStringLiteralDfa6_0(active0, 0x300000L);
      case 84:
         return jjMoveStringLiteralDfa6_0(active0, 0x80000L);
      case 97:
         return jjMoveStringLiteralDfa6_0(active0, 0x8000000L);
      case 99:
         return jjMoveStringLiteralDfa6_0(active0, 0x20000L);
      case 100:
         return jjMoveStringLiteralDfa6_0(active0, 0x4000L);
      case 101:
         return jjMoveStringLiteralDfa6_0(active0, 0x40000000L);
      case 108:
         return jjMoveStringLiteralDfa6_0(active0, 0x10000L);
      case 114:
         return jjMoveStringLiteralDfa6_0(active0, 0x2000L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
static private int jjMoveStringLiteralDfa6_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 65:
         return jjMoveStringLiteralDfa7_0(active0, 0x300000L);
      case 79:
         return jjMoveStringLiteralDfa7_0(active0, 0x80000L);
      case 97:
         if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(6, 16, 1);
         break;
      case 101:
         return jjMoveStringLiteralDfa7_0(active0, 0x2000L);
      case 103:
         return jjMoveStringLiteralDfa7_0(active0, 0x8000000L);
      case 115:
         if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(6, 14, 1);
         else if ((active0 & 0x40000000L) != 0L)
            return jjStartNfaWithStates_0(6, 30, 1);
         break;
      case 116:
         if ((active0 & 0x20000L) != 0L)
            return jjStartNfaWithStates_0(6, 17, 1);
         break;
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
static private int jjMoveStringLiteralDfa7_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 76:
         if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(7, 20, 1);
         break;
      case 78:
         return jjMoveStringLiteralDfa8_0(active0, 0x2000L);
      case 82:
         return jjMoveStringLiteralDfa8_0(active0, 0x80000L);
      case 84:
         return jjMoveStringLiteralDfa8_0(active0, 0x200000L);
      case 101:
         if ((active0 & 0x8000000L) != 0L)
            return jjStartNfaWithStates_0(7, 27, 1);
         break;
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
static private int jjMoveStringLiteralDfa8_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(6, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0);
      return 8;
   }
   switch(curChar)
   {
      case 73:
         return jjMoveStringLiteralDfa9_0(active0, 0x200000L);
      case 89:
         if ((active0 & 0x80000L) != 0L)
            return jjStartNfaWithStates_0(8, 19, 1);
         break;
      case 97:
         return jjMoveStringLiteralDfa9_0(active0, 0x2000L);
      default :
         break;
   }
   return jjStartNfa_0(7, active0);
}
static private int jjMoveStringLiteralDfa9_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(7, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(8, active0);
      return 9;
   }
   switch(curChar)
   {
      case 86:
         return jjMoveStringLiteralDfa10_0(active0, 0x200000L);
      case 109:
         return jjMoveStringLiteralDfa10_0(active0, 0x2000L);
      default :
         break;
   }
   return jjStartNfa_0(8, active0);
}
static private int jjMoveStringLiteralDfa10_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(8, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(9, active0);
      return 10;
   }
   switch(curChar)
   {
      case 69:
         if ((active0 & 0x200000L) != 0L)
            return jjStartNfaWithStates_0(10, 21, 1);
         break;
      case 101:
         if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(10, 13, 1);
         break;
      default :
         break;
   }
   return jjStartNfa_0(9, active0);
}
static private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0x1ff00000fffffffeL, 0xffffffffffffc000L, 0xffffffffL, 0x600000000000000L
};
static final long[] jjbitVec2 = {
   0x0L, 0x0L, 0x0L, 0xff7fffffff7fffffL
};
static final long[] jjbitVec3 = {
   0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec4 = {
   0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffL, 0x0L
};
static final long[] jjbitVec5 = {
   0xffffffffffffffffL, 0xffffffffffffffffL, 0x0L, 0x0L
};
static final long[] jjbitVec6 = {
   0x3fffffffffffL, 0x0L, 0x0L, 0x0L
};
static private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 2;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if (curChar != 36)
                     break;
                  if (kind > 34)
                     kind = 34;
                  { jjCheckNAdd(1); }
                  break;
               case 1:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 34)
                     kind = 34;
                  { jjCheckNAdd(1); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
               case 1:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 34)
                     kind = 34;
                  { jjCheckNAdd(1); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int hiByte = (curChar >> 8);
         int i1 = hiByte >> 6;
         long l1 = 1L << (hiByte & 077);
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
               case 1:
                  if (!jjCanMove_0(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 34)
                     kind = 34;
                  { jjCheckNAdd(1); }
                  break;
               default : if (i1 == 0 || l1 == 0 || i2 == 0 ||  l2 == 0) break; else break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 2 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, "\50", "\51", "\173", "\175", "\73", "\54", 
"\120\114", "\106\145\141\164\165\162\145\116\141\155\145", 
"\145\170\164\145\156\144\163", "\141\163", "\106\157\162\155\165\154\141", "\120\162\157\144\165\143\164", 
"\122\117\117\124", "\115\101\116\104\101\124\117\122\131", "\117\120\124\111\117\116\101\114", 
"\101\114\124\105\122\116\101\124\111\126\105", "\117\122", "\157\146\157\164", "\163\157\146\157\164", "\141\151\146\154", 
"\163\151\172\145", "\143\157\166\145\162\141\147\145", "\164\145\163\164\77", "\75", 
"\151\155\160\154\151\145\163", "\141\156\144", "\157\162", "\156\157\164", null, null, null, };
static protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}
static final int[] jjnextStates = {0
};
private static final boolean jjCanMove_0(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec2[i2] & l2) != 0L);
      case 48:
         return ((jjbitVec3[i2] & l2) != 0L);
      case 49:
         return ((jjbitVec4[i2] & l2) != 0L);
      case 51:
         return ((jjbitVec5[i2] & l2) != 0L);
      case 61:
         return ((jjbitVec6[i2] & l2) != 0L);
      default :
         if ((jjbitVec0[i1] & l1) != 0L)
            return true;
         return false;
   }
}

static int curLexState = 0;
static int defaultLexState = 0;
static int jjnewStateCnt;
static int jjround;
static int jjmatchedPos;
static int jjmatchedKind;

/** Get the next Token. */
public static Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(Exception e)
   {
      jjmatchedKind = 0;
      jjmatchedPos = -1;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100003600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

static void SkipLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      default :
         break;
   }
}
static void MoreLexicalActions()
{
   jjimageLen += (lengthOfMatch = jjmatchedPos + 1);
   switch(jjmatchedKind)
   {
      default :
         break;
   }
}
static void TokenLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      default :
         break;
   }
}
static private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
static private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
static private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

    /** Constructor. */
    public SPL1TokenManager(SimpleCharStream stream){

      if (input_stream != null)
        throw new TokenMgrError("ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", TokenMgrError.STATIC_LEXER_ERROR);

    input_stream = stream;
  }

  /** Constructor. */
  public SPL1TokenManager (SimpleCharStream stream, int lexState){
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Reinitialise parser. */
  
  static public void ReInit(SimpleCharStream stream)
  {


    jjmatchedPos =
    jjnewStateCnt =
    0;
    curLexState = defaultLexState;
    input_stream = stream;
    ReInitRounds();
  }

  static private void ReInitRounds()
  {
    int i;
    jjround = 0x80000001;
    for (i = 2; i-- > 0;)
      jjrounds[i] = 0x80000000;
  }

  /** Reinitialise parser. */
  static public void ReInit(SimpleCharStream stream, int lexState)
  
  {
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Switch to specified lex state. */
  public static void SwitchTo(int lexState)
  {
    if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
    else
      curLexState = lexState;
  }


/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};

/** Lex State array. */
public static final int[] jjnewLexState = {
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
};
static final long[] jjtoToken = {
   0x7ffffffc1L, 
};
static final long[] jjtoSkip = {
   0x3eL, 
};
static final long[] jjtoSpecial = {
   0x0L, 
};
static final long[] jjtoMore = {
   0x0L, 
};
    static protected SimpleCharStream  input_stream;

    static private final int[] jjrounds = new int[2];
    static private final int[] jjstateSet = new int[2 * 2];
    private static final StringBuilder jjimage = new StringBuilder();
    private static StringBuilder image = jjimage;
    private static int jjimageLen;
    private static int lengthOfMatch;
    static protected int curChar;
}
