/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.onion.network.protocol;


import com.google.common.primitives.Longs;
import com.onion.network.databuffer.DataBuffer;
import com.onion.network.databuffer.DataByteBuffer;
import io.netty.buffer.ByteBuf;

import java.nio.ByteBuffer;

public class RPCBlockWriteRequest extends RPCRequest {
    private final long sessionId;
    private final long blockId;
    private final long offSet;
    private final long length;
    private final DataBuffer dataBuffer;



    public RPCBlockWriteRequest(long sessionId, long blockId, long offSet,
                                long length, DataBuffer dataBuffer) {
        this.sessionId = sessionId;
        this.blockId = blockId;
        this.offSet = offSet;
        this.length = length;
        this.dataBuffer = dataBuffer;
    }

    @Override
    public Type getType() {
        return Type.RPC_BLOCK_WRITE_REQUEST;
    }

    public static RPCBlockWriteRequest decode(ByteBuf in) {
        long sessionId = in.readLong();
        long blockId = in.readLong();
        long offSet = in.readLong();
        long length = in.readLong();
        DataBuffer dataBuffer = null;
        if (length > 0) {
            ByteBuffer buffer = ByteBuffer.allocate((int) length);
            in.readBytes(buffer);
            dataBuffer = new DataByteBuffer(buffer, (int) length);
        }
        return new RPCBlockWriteRequest(sessionId, blockId, offSet, length, dataBuffer);
    }

    public int getEncodedLength() {
        return Longs.BYTES * 4;
    }

    public void encode(ByteBuf out) {
        out.writeLong(sessionId);
        out.writeLong(blockId);
        out.writeLong(offSet);
        out.writeLong(length);
    }

    public long getSessionId() {
        return sessionId;
    }

    public long getBlockId() {
        return blockId;
    }

    public long getLength() {
        return length;
    }

    public long getOffSet() {
        return offSet;
    }
}