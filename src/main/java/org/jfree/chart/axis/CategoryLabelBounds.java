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
 * -------------------------
 * CategoryLabelBounds.java
 * -------------------------
 * (C) Copyright 2026-present, by David Gilbert and Contributors.
 *
 * Original Author:  David Gilbert;
 * Contributor(s):   -;
 *
 */

package org.jfree.chart.axis;

import java.awt.geom.Rectangle2D;
import java.util.Objects;

/**
 * A value object that holds the calculated bounds for a category label.
 * This class makes the internal coordinate calculations observable for testing.
 */
public class CategoryLabelBounds {
    
    /** The minimum x coordinate. */
    private final double x0;
    
    /** The maximum x coordinate. */
    private final double x1;
    
    /** The minimum y coordinate. */
    private final double y0;
    
    /** The maximum y coordinate. */
    private final double y1;
    
    /**
     * Creates a new CategoryLabelBounds instance.
     * 
     * @param x0 the minimum x coordinate
     * @param x1 the maximum x coordinate
     * @param y0 the minimum y coordinate
     * @param y1 the maximum y coordinate
     */
    public CategoryLabelBounds(double x0, double x1, double y0, double y1) {
        this.x0 = x0;
        this.x1 = x1;
        this.y0 = y0;
        this.y1 = y1;
    }
    
    /**
     * Returns the minimum x coordinate.
     * 
     * @return the minimum x coordinate
     */
    public double getX0() {
        return this.x0;
    }
    
    /**
     * Returns the maximum x coordinate.
     * 
     * @return the maximum x coordinate
     */
    public double getX1() {
        return this.x1;
    }
    
    /**
     * Returns the minimum y coordinate.
     * 
     * @return the minimum y coordinate
     */
    public double getY0() {
        return this.y0;
    }
    
    /**
     * Returns the maximum y coordinate.
     * 
     * @return the maximum y coordinate
     */
    public double getY1() {
        return this.y1;
    }
    
    /**
     * Returns the bounds as a Rectangle2D.
     * 
     * @return the bounds as a rectangle
     */
    public Rectangle2D toRectangle() {
        return new Rectangle2D.Double(this.x0, this.y0, this.x1 - this.x0, this.y1 - this.y0);
    }
    
    /**
     * Tests this object for equality with an arbitrary object.
     * 
     * @param obj the object to test against
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CategoryLabelBounds)) {
            return false;
        }
        CategoryLabelBounds that = (CategoryLabelBounds) obj;
        return this.x0 == that.x0 && this.x1 == that.x1 
                && this.y0 == that.y0 && this.y1 == that.y1;
    }
    
    /**
     * Returns a hash code for this object.
     * 
     * @return a hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.x0, this.x1, this.y0, this.y1);
    }
    
    /**
     * Returns a string representation of this object.
     * 
     * @return a string representation
     */
    @Override
    public String toString() {
        return "CategoryLabelBounds[x0=" + this.x0 + ", x1=" + this.x1 
                + ", y0=" + this.y0 + ", y1=" + this.y1 + "]";
    }
}