package com.garmin.gwt.client;

/*
 * #%L
 * GWT Maps API V3 - Core API
 * %%
 * Copyright (C) 2011 - 2012 GWT Maps API V3
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.garmin.gwt.client.base.LatLng;
import com.google.gwt.junit.client.GWTTestCase;

/**
 * Common actions taken when testing maps code
 * 
 * @author Joseph Lust
 * 
 */
public abstract class AbstractMapsGWTTestHelper extends GWTTestCase {

  private final String MODULE_NAME = "com.garmin.gwt.Garmin";
  private int asyncDelayMs = 30000;
  private final double equalsEpsilon = 1e-3;
  /**
   * Runs the test with the given libraries loaded and fails if not complete by {@link #getAsyncDelayMs()}.<br>
   * <br>
   * <b>NOTE:</b> You must call {@link #finishTest()} or test will fail.
   * 
   * @param test code to run
   * @param libs libraries to have loaded
   */
  public final void asyncLibTest(Runnable test) {
    // pack
    test.run();

    // ensure expiration is does not reach finishTest()
    delayTest();
  }

  public final void delayTest() {
    delayTestFinish(getAsyncDelayMs());
  }

  /**
   * Get delay to wait until failing the test as incomplete
   * 
   * @return
   */
  public final int getAsyncDelayMs() {
    return asyncDelayMs;
  }

  @Override
  public String getModuleName() {
    return MODULE_NAME;
  }

  public final void setAsyncDelayMs(int asyncDelayMs) {
    this.asyncDelayMs = asyncDelayMs;
  }

  public final double getEqualsEpsilon() {
    return equalsEpsilon;
  }

  /** HELPERS **/

  /**
   * Assert that two {@link LatLng} are equal within {@link #getEqualsEpsilon()} .
   * 
   * @param expected
   * @param actual
   */
  public final void assertLatLngEquals(LatLng expected, LatLng actual) {
    assert expected != null : "Point1 cannot be null in assertLatLngEquals()";
    assert actual != null : "Point2 cannot be null in assertLatLngEquals()";

    assertEquals("Latitude not equal within epsilon", expected.getLatitude(), actual.getLatitude(),getEqualsEpsilon());
    assertEquals("Longitude not equal within epsilon", expected.getLongitude(), actual.getLongitude(),getEqualsEpsilon());
  }

}
