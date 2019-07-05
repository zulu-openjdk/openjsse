/*
 * Copyright 2019 Azul Systems, Inc.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package org.openjsse.util;

import java.security.interfaces.RSAKey;
import java.security.spec.AlgorithmParameterSpec;
import org.openjsse.sun.security.rsa.RSAPrivateKeyImpl;
import org.openjsse.sun.security.rsa.RSAPrivateCrtKeyImpl;
import org.openjsse.sun.security.rsa.RSAPublicKeyImpl;

/**
 * Utility class to access parameters associated with RSA key.
 *
 */
public class RSAKeyUtil {
    /**
     * Returns the parameters associated with RSA key.
     * The parameters are optional and may be either
     * explicitly specified or implicitly created during
     * key pair generation.
     *
     * @param rsaKey RSA key whose parameters should be returned
     *
     * @return the associated parameters, may be null
     */
    public static AlgorithmParameterSpec getParams(RSAKey rsaKey) {
        AlgorithmParameterSpec keyParams = null;
        if (rsaKey instanceof RSAPublicKeyImpl)
            keyParams = ((RSAPublicKeyImpl) rsaKey).getParams();
        else if (rsaKey instanceof RSAPrivateCrtKeyImpl)
            keyParams = ((RSAPrivateCrtKeyImpl) rsaKey).getParams();
        else if (rsaKey instanceof RSAPrivateKeyImpl)
            keyParams = ((RSAPrivateKeyImpl) rsaKey).getParams();
        return keyParams;
    }


    private RSAKeyUtil() {};
}
