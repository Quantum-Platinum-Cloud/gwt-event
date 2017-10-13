/*
 * Copyright 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.gwtproject.event.compat.shared;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;

/** For {@link EventBus} tests. */
public class BarGwtEvent extends GwtEvent<BarGwtEvent.Handler> {
  /** The handler for the event. */
  public interface Handler extends EventHandler {
    void onBar(BarGwtEvent e);
  }

  public static final Type<Handler> TYPE = new Type<>();

  public static HandlerRegistration register(EventBus bus, Handler handler) {
    return bus.addHandler(TYPE, handler);
  }

  public static HandlerRegistration register(EventBus bus, Object source, Handler handler) {
    return bus.addHandlerToSource(TYPE, source, handler);
  }

  @Override
  public Type<Handler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(Handler handler) {
    handler.onBar(this);
  }
}
