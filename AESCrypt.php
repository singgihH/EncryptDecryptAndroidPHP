<?php

class AESCrypt {
  
  public function encrypt($wordEnc) 
  {
    $key16 = substr("YOUR_KEY", 0, 16);
    $key16Hex = unpack('H*', $key16);
    return openssl_encrypt($word, 'AES-128-CBC', $key16, 0, hex2bin($key16Hex[1]));
  }

  public function decrypt($wordDec) 
  {
    $key16 = substr("YOUR_KEY", 0, 16);
    $key16Hex = unpack('H*', $key16); 
    return openssl_decrypt($wordDec, "AES-128-CBC", $key16, 0, hex2bin($key16Hex[1])
  }

}
