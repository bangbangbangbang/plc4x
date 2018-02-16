/*
 Licensed to the Apache Software Foundation (ASF) under one
 or more contributor license agreements.  See the NOTICE file
 distributed with this work for additional information
 regarding copyright ownership.  The ASF licenses this file
 to you under the Apache License, Version 2.0 (the
 "License"); you may not use this file except in compliance
 with the License.  You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing,
 software distributed under the License is distributed on an
 "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 KIND, either express or implied.  See the License for the
 specific language governing permissions and limitations
 under the License.
 */
package org.apache.plc4x.java.ads.api.commands;

import org.apache.plc4x.java.ads.api.commands.types.AdsStampHeader;
import org.apache.plc4x.java.ads.api.commands.types.Length;
import org.apache.plc4x.java.ads.api.commands.types.Stamps;
import org.apache.plc4x.java.ads.api.generic.ADSData;
import org.apache.plc4x.java.ads.api.generic.AMSHeader;
import org.apache.plc4x.java.ads.api.generic.AMSTCPHeader;
import org.apache.plc4x.java.ads.api.generic.types.AMSNetId;
import org.apache.plc4x.java.ads.api.generic.types.AMSPort;
import org.apache.plc4x.java.ads.api.generic.types.Command;
import org.apache.plc4x.java.ads.api.generic.types.Invoke;
import org.apache.plc4x.java.ads.api.util.ByteReadable;

import java.util.List;

/**
 * Data will carry forward independently from an ADS device to a Client
 * <p>
 * The data which are transfered at the Device Notification  are multiple nested into one another. The Notification Stream contains an array with elements of type AdsStampHeader. This array again contains elements of type AdsNotificationSample.
 */
@ADSCommandType(Command.ADS_Device_Notification)
public class ADSDeviceNotificationRequest extends ADSAbstractRequest {

    /**
     * 4 bytes	Size of data in byte.
     */
    private final Length length;
    /**
     * 4 bytes	Number of elements of type AdsStampHeader.
     */
    private final Stamps stamps;
    /**
     * n bytes	Array with elements of type AdsStampHeader.
     */
    private final List<AdsStampHeader> adsStampHeaders;

    protected ADSDeviceNotificationRequest(AMSTCPHeader amstcpHeader, AMSHeader amsHeader, Length length, Stamps stamps, List<AdsStampHeader> adsStampHeaders) {
        super(amstcpHeader, amsHeader);
        this.length = length;
        this.stamps = stamps;
        this.adsStampHeaders = adsStampHeaders;
    }

    protected ADSDeviceNotificationRequest(AMSHeader amsHeader, Length length, Stamps stamps, List<AdsStampHeader> adsStampHeaders) {
        super(amsHeader);
        this.length = length;
        this.stamps = stamps;
        this.adsStampHeaders = adsStampHeaders;
    }

    protected ADSDeviceNotificationRequest(AMSNetId targetAmsNetId, AMSPort targetAmsPort, AMSNetId sourceAmsNetId, AMSPort sourceAmsPort, Invoke invokeId, Length length, Stamps stamps, List<AdsStampHeader> adsStampHeaders) {
        super(targetAmsNetId, targetAmsPort, sourceAmsNetId, sourceAmsPort, invokeId);
        this.length = length;
        this.stamps = stamps;
        this.adsStampHeaders = adsStampHeaders;
    }

    public static ADSDeviceNotificationRequest of(AMSTCPHeader amstcpHeader, AMSHeader amsHeader, Length length, Stamps stamps, List<AdsStampHeader> adsStampHeaders) {
        return new ADSDeviceNotificationRequest(amstcpHeader, amsHeader, length, stamps, adsStampHeaders);
    }

    public static ADSDeviceNotificationRequest of(AMSHeader amsHeader, Length length, Stamps stamps, List<AdsStampHeader> adsStampHeaders) {
        return new ADSDeviceNotificationRequest(amsHeader, length, stamps, adsStampHeaders);
    }

    public static ADSDeviceNotificationRequest of(AMSNetId targetAmsNetId, AMSPort targetAmsPort, AMSNetId sourceAmsNetId, AMSPort sourceAmsPort, Invoke invokeId, Length length, Stamps stamps, List<AdsStampHeader> adsStampHeaders) {
        return new ADSDeviceNotificationRequest(targetAmsNetId, targetAmsPort, sourceAmsNetId, sourceAmsPort, invokeId, length, stamps, adsStampHeaders);
    }

    @Override
    public ADSData getAdsData() {
        return buildADSData(length, stamps, buildADSData(adsStampHeaders.toArray(new ByteReadable[adsStampHeaders.size()])));
    }

    @Override
    public String toString() {
        return "ADSDeviceNotificationRequest{" +
            "length=" + length +
            ", stamps=" + stamps +
            ", adsStampHeaders=" + adsStampHeaders +
            "} " + super.toString();
    }
}
