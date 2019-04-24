
// Dsp-block f2_signal_definitions
// Description here 
// Inititally written by dsp-blocks initmodule.sh, 20190424
package f2_signal_definitions

import chisel3.experimental._
import chisel3._
import dsptools._
import dsptools.numbers._
import breeze.math.Complex

class f2_signal_definitions_io[T <:Data](proto: T,n: Int) 
   extends Bundle {
        val A       = Input(Vec(n,proto))
        val B       = Output(Vec(n,proto))
        override def cloneType = (new f2_signal_definitions_io(proto.cloneType,n)).asInstanceOf[this.type]
   }

class f2_signal_definitions[T <:Data] (proto: T,n: Int) extends Module {
    val io = IO(new f2_signal_definitions_io( proto=proto, n=n))
    val register=RegInit(VecInit(Seq.fill(n)(0.U.asTypeOf(proto.cloneType))))
    register:=io.A
    io.B:=register
}

//This gives you verilog
object f2_signal_definitions extends App {
    chisel3.Driver.execute(args, () => new f2_signal_definitions(
        proto=DspComplex(UInt(16.W),UInt(16.W)), n=8) 
    )
}
