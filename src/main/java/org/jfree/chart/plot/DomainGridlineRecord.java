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
 * DomainGridlineRecord.java
 * -------------------------
 * (C) Copyright 2026-present, by Contributors.
 *
 */

package org.jfree.chart.plot;

import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.util.Objects;

import org.jfree.chart.axis.ValueAxis;

/**
 * A record that captures information about a domain gridline being drawn.
 * This class is used to improve test observability by recording the parameters
 * passed to the drawDomainLine method.
 */
public class DomainGridlineRecord {
    
    private final double value;
    private final ValueAxis axis;
    private final Rectangle2D dataArea;
    private final Paint paint;
    private final Stroke stroke;
    
    /**
     * Creates a new record of a domain gridline.
     * 
     * @param value  the tick value.
     * @param axis  the domain axis.
     * @param dataArea  the data area.
     * @param paint  the paint used for the gridline.
     * @param stroke  the stroke used for the gridline.
     */
    public DomainGridlineRecord(double value, ValueAxis axis, 
            Rectangle2D dataArea, Paint paint, Stroke stroke) {
        this.value = value;
        this.axis = axis;
        this.dataArea = dataArea != null 
                ? (Rectangle2D) dataArea.clone() : null;
        this.paint = paint;
        this.stroke = stroke;
    }
    
    /**
     * Returns the tick value.
     * 
     * @return The tick value.
     */
    public double getValue() {
        return this.value;
    }
    
    /**
     * Returns the axis.
     * 
     * @return The axis.
     */
    public ValueAxis getAxis() {
        return this.axis;
    }
    
    /**
     * Returns the data area.
     * 
     * @return The data area (a copy).
     */
    public Rectangle2D getDataArea() {
        return this.dataArea != null 
                ? (Rectangle2D) this.dataArea.clone() : null;
    }
    
    /**
     * Returns the paint.
     * 
     * @return The paint.
     */
    public Paint getPaint() {
        return this.paint;
    }
    
    /**
     * Returns the stroke.
     * 
     * @return The stroke.
     */
    public Stroke getStroke() {
        return this.stroke;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DomainGridlineRecord)) {
            return false;
        }
        DomainGridlineRecord that = (DomainGridlineRecord) obj;
        return Double.compare(this.value, that.value) == 0
                && Objects.equals(this.axis, that.axis)
                && Objects.equals(this.dataArea, that.dataArea)
                && Objects.equals(this.paint, that.paint)
                && Objects.equals(this.stroke, that.stroke);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(value, axis, dataArea, paint, stroke);
    }
    
    @Override
    public String toString() {
        return "DomainGridlineRecord[value=" + value 
                + ", axis=" + axis
                + ", dataArea=" + dataArea
                + ", paint=" + paint
                + ", stroke=" + stroke + "]";
    }
}