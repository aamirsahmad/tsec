package tsec.libsodium.authentication.internal

import tsec.libsodium.ScalaSodium
import tsec.libsodium.authentication.{SodiumMAC, SodiumMACKey}

trait SodiumMacAlgo[A] {
  val keyLen: Int
  val macLen: Int
  val algorithm: String

  private[tsec] def sodiumSign(in: Array[Byte], out: Array[Byte], key: SodiumMACKey[A])(implicit S: ScalaSodium): Int

  private[tsec] def sodiumVerify(in: Array[Byte], hashed: SodiumMAC[A], key: SodiumMACKey[A])(
      implicit S: ScalaSodium
  ): Int

}
