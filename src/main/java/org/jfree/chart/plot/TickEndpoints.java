/* ======================================================
 * JFreeChart : a chart library for the Java(tm) platform
 * ======================================================
 *
 * (C) Copyright 2000-present, by David Gilbert and Contributors.
 *
 * Project Info:  https://www.jfree.org/jfreechart/index.html
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Oracle and Java are registered trademarks of Oracle and/or its affiliates. 
 * Other names may be trademarks of their respective owners.]
 *
 * ------------------
 * TickEndpoints.java
 * ------------------
 * (C) Copyright 2000-present, by David Gilbert and Contributors.
 *
 * Original Author:  David Gilbert;
 * Contributor(s):   -;
 */

package org.jfree.chart.plot;

import java.util.Objects;

/**
 * A simple data structure to hold the start and end points of a tick mark
 * on a meter plot dial.
 */
public class TickEndpoints {
    
    /** The x-coordinate of the outer endpoint (on the dial perimeter). */
    private final double x1;
    
    /** The y-coordinate of the outer endpoint (on the dial perimeter). */
    private final double y1;
    
    /** The x-coordinate of the inner endpoint (toward the dial center). */
    private final double x2;
    
    /** The y-coordinate of the inner endpoint (toward the dial center). */
    private final double y2;
    
    /**
     * Creates a new instance.
     * 
     * @param x1  the x-coordinate of the outer endpoint.
     * @param y1  the y-coordinate of the outer endpoint.
     * @param x2  the x-coordinate of the inner endpoint.
     * @param y2  the y-coordinate of the inner endpoint.
     */
    public TickEndpoints(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    
    /**
     * Returns the x-coordinate of the outer endpoint.
     * 
     * @return The x-coordinate.
     */
    public double getX1() {
        return this.x1;
    }
    
    /**
     * Returns the y-coordinate of the outer endpoint.
     * 
     * @return The y-coordinate.
     */
    public double getY1() {
        return this.y1;
    }
    
    /**
     * Returns the x-coordinate of the inner endpoint.
     * 
     * @return The x-coordinate.
     */
    public double getX2() {
        return this.x2;
    }
    
    /**
     * Returns the y-coordinate of the inner endpoint.
     * 
     * @return The y-coordinate.
     */
    public double getY2() {
        return this.y2;
    }
    
    /**
     * Tests this instance for equality with an arbitrary object.
     * 
     * @param obj  the object ({@code null} permitted).
     * 
     * @return A boolean.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TickEndpoints)) {
            return false;
        }
        TickEndpoints that = (TickEndpoints) obj;
        return this.x1 == that.x1 && this.y1 == that.y1 
                && this.x2 == that.x2 && this.y2 == that.y2;
    }
    
    /**
     * Returns a hash code for this instance.
     * 
     * @return A hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(x1, y1, x2, y2);
    }
    
    /**
     * Returns a string representation of this instance.
     * 
     * @return A string.
     */
    @Override
    public String toString() {
        return "TickEndpoints[x1=" + x1 + ", y1=" + y1 
                + ", x2=" + x2 + ", y2=" + y2 + "]";
    }
}