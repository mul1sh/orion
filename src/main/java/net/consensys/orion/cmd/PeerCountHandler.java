/*
 * Copyright 2019 ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package net.consensys.orion.cmd;

import java.util.function.Supplier;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

// Responsible for reporting the number of connected peers:
public class PeerCountHandler implements Handler<RoutingContext> {

  private final Supplier<Integer> peerCountSupplier;

  public PeerCountHandler(final Supplier<Integer> peerCountSupplier) {
    this.peerCountSupplier = peerCountSupplier;
  }

  @Override
  public void handle(final RoutingContext routingContext) {
    routingContext.response().end(this.peerCountSupplier.get().toString());
  }
}
