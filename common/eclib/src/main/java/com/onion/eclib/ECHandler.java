/*
 * Licensed to the University of California, Berkeley under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.onion.eclib;

import java.io.File;

/**
 * This is a hanlder to encode and decode a file. A wrapper for ErasureCoder.java.
 */
public class ECHandler {
    private ErasureCoder coder;


    /**
     * A constructor for ECHandler, parameter is not determined.
     */
    public ECHandler() {
        //TODO
    }

    /**
     * Encode a file to k byte arrays
     * @param dataPath file path
     * @param encodeData
     */
    public void encode(String dataPath, byte[][] encodeData) {
        encode(new File(dataPath), encodeData);
    }

    /**
     *  Encode a file to k byte arrays
     * @param dataFile
     * @param encodedData
     */
    public void encode(File dataFile, byte[][] encodedData) {
        //TODO
    }

    /**
     * Decode a file from a group of byte arrays
     * @param encodedData
     * @param decodedData
     */
    public void decode(byte[][] encodedData, byte[] decodedData) {
        //TODO
    }
}
