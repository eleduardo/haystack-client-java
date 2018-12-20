/*
 *  Copyright 2018 Expedia, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */

package com.expedia.www.opencensus.exporter.trace.config;

import org.apache.commons.lang3.Validate;

public class GrpcAgentDispatcherConfig extends DispatcherConfig {

    private final String host;
    private int port;

    public GrpcAgentDispatcherConfig() {
        this("haystack-agent", 35000);
    }

    public GrpcAgentDispatcherConfig(final String host,
                                     final int port) {
        this(host, port, 5000);
    }

    public GrpcAgentDispatcherConfig(final String host,
                                     final int port,
                                     final long shutdownTimeoutInMillis) {
        super(shutdownTimeoutInMillis);

        Validate.notEmpty(host);
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    @Override
    public DispatchType getType() {
        return DispatchType.GRPC;
    }
}
