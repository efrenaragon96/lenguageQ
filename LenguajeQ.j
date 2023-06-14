; public class LenguajeQ extends Object { ...}
.class public LenguajeQ
.super java/lang/Object

; Constructor de la clase
.method public <init>()V
   .limit stack 1
   .limit locals 1
   aload_0
   invokespecial java/lang/Object/<init>()V
   return
.end method

; main()
.method public static main([Ljava/lang/String;)V
   .limit stack 5 ; how much stack space do we need?
   .limit locals 3 ; how many locals do we need?
   ; code translated from input stream
   ; Asignando un valor Var Local: -> Line 2
   ldc 0.0
   ; Sumando
   ldc 5
   i2f
   fadd
   ; Sumando
   ldc 10
   i2f
   fadd
   ; Sumando
   ldc 0.0
   ; Sumando
   ldc 2
   i2f
   fadd
   ; Sumando
   ldc 4
   i2f
   fadd
   ldc 2.0
   fdiv    
   fadd
   ldc 3.0
   fdiv    
   fstore 2 ; s
   ; Imprimiendo un valor
   getstatic java/lang/System/out Ljava/io/PrintStream;
   fload 2 ; s
   invokevirtual java/io/PrintStream/println(F)V
   return
.end method