//Consider using "unit" instead of "User" 
package f2_signal_definitions
class usersigs (val n: Int, val users: Int=4) extends Bundle {
    val udata=DspComplex(SInt(n.W), SInt(n.W))
    val uindex=UInt(log2Ceil(users).W)
}

class iofifosigs(val n: Int, val users: Int=4 ) extends Bundle {
        //4=Users
        val data=Vec(users,new usersigs(n=n,users=users))
        val rxindex=UInt(2.W)
        override def cloneType = (new iofifosigs(n,users)).asInstanceOf[this.type]
}

