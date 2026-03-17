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
 * MeterPlotTest.java
 * ------------------
 * (C) Copyright 2003-present, by David Gilbert and Contributors.
 *
 * Original Author:  David Gilbert;
 * Contributor(s):   -;
 */

package org.jfree.chart.plot;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.text.DecimalFormat;

import org.jfree.chart.TestUtils;

import org.jfree.data.Range;
import org.jfree.data.general.DefaultValueDataset;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the {@link MeterPlot} class.
 */
public class MeterPlotTest {

    /**
     * Test the equals method to ensure that it can distinguish the required
     * fields.  Note that the dataset is NOT considered in the equals test.
     */
    @Test
    public void testEquals() {
        MeterPlot plot1 = new MeterPlot();
        MeterPlot plot2 = new MeterPlot();
        assertEquals(plot1, plot2);

        // units
        plot1.setUnits("mph");
        assertNotEquals(plot1, plot2);
        plot2.setUnits("mph");
        assertEquals(plot1, plot2);

        // range
        plot1.setRange(new Range(50.0, 70.0));
        assertNotEquals(plot1, plot2);
        plot2.setRange(new Range(50.0, 70.0));
        assertEquals(plot1, plot2);

        // interval
        plot1.addInterval(new MeterInterval("Normal", new Range(55.0, 60.0)));
        assertNotEquals(plot1, plot2);
        plot2.addInterval(new MeterInterval("Normal", new Range(55.0, 60.0)));
        assertEquals(plot1, plot2);

        // dial outline paint
        plot1.setDialOutlinePaint(new GradientPaint(1.0f, 2.0f, Color.RED,
                3.0f, 4.0f, Color.BLUE));
        assertNotEquals(plot1, plot2);
        plot2.setDialOutlinePaint(new GradientPaint(1.0f, 2.0f, Color.RED,
                3.0f, 4.0f, Color.BLUE));
        assertEquals(plot1, plot2);

        // dial shape
        plot1.setDialShape(DialShape.CHORD);
        assertNotEquals(plot1, plot2);
        plot2.setDialShape(DialShape.CHORD);
        assertEquals(plot1, plot2);

        // dial background paint
        plot1.setDialBackgroundPaint(new GradientPaint(9.0f, 8.0f, Color.RED,
                7.0f, 6.0f, Color.BLUE));
        assertNotEquals(plot1, plot2);
        plot2.setDialBackgroundPaint(new GradientPaint(9.0f, 8.0f, Color.RED,
                7.0f, 6.0f, Color.BLUE));
        assertEquals(plot1, plot2);

        // dial outline paint
        plot1.setDialOutlinePaint(new GradientPaint(1.0f, 2.0f, Color.GREEN,
                3.0f, 4.0f, Color.RED));
        assertNotEquals(plot1, plot2);
        plot2.setDialOutlinePaint(new GradientPaint(1.0f, 2.0f, Color.GREEN,
                3.0f, 4.0f, Color.RED));
        assertEquals(plot1, plot2);

        // needle paint
        plot1.setNeedlePaint(new GradientPaint(9.0f, 8.0f, Color.RED,
                7.0f, 6.0f, Color.BLUE));
        assertNotEquals(plot1, plot2);
        plot2.setNeedlePaint(new GradientPaint(9.0f, 8.0f, Color.RED,
                7.0f, 6.0f, Color.BLUE));
        assertEquals(plot1, plot2);

        // value visible
        plot1.setValueVisible(false);
        assertNotEquals(plot1, plot2);
        plot2.setValueVisible(false);
        assertEquals(plot1, plot2);

        // value font
        plot1.setValueFont(new Font("Serif", Font.PLAIN, 6));
        assertNotEquals(plot1, plot2);
        plot2.setValueFont(new Font("Serif", Font.PLAIN, 6));
        assertEquals(plot1, plot2);

        // value paint
        plot1.setValuePaint(new GradientPaint(1.0f, 2.0f, Color.BLACK,
                3.0f, 4.0f, Color.WHITE));
        assertNotEquals(plot1, plot2);
        plot2.setValuePaint(new GradientPaint(1.0f, 2.0f, Color.BLACK,
                3.0f, 4.0f, Color.WHITE));
        assertEquals(plot1, plot2);

        // tick labels visible
        plot1.setTickLabelsVisible(false);
        assertNotEquals(plot1, plot2);
        plot2.setTickLabelsVisible(false);
        assertEquals(plot1, plot2);

        // tick label font
        plot1.setTickLabelFont(new Font("Serif", Font.PLAIN, 6));
        assertNotEquals(plot1, plot2);
        plot2.setTickLabelFont(new Font("Serif", Font.PLAIN, 6));
        assertEquals(plot1, plot2);

        // tick label paint
        plot1.setTickLabelPaint(Color.RED);
        assertNotEquals(plot1, plot2);
        plot2.setTickLabelPaint(Color.RED);
        assertEquals(plot1, plot2);

        // tick label format
        plot1.setTickLabelFormat(new DecimalFormat("0"));
        assertNotEquals(plot1, plot2);
        plot2.setTickLabelFormat(new DecimalFormat("0"));
        assertEquals(plot1, plot2);

        // tick paint
        plot1.setTickPaint(Color.GREEN);
        assertNotEquals(plot1, plot2);
        plot2.setTickPaint(Color.GREEN);
        assertEquals(plot1, plot2);

        // tick size
        plot1.setTickSize(1.23);
        assertNotEquals(plot1, plot2);
        plot2.setTickSize(1.23);
        assertEquals(plot1, plot2);

        // draw border
        plot1.setDrawBorder(!plot1.getDrawBorder());
        assertNotEquals(plot1, plot2);
        plot2.setDrawBorder(plot1.getDrawBorder());
        assertEquals(plot1, plot2);

        // meter angle
        plot1.setMeterAngle(22);
        assertNotEquals(plot1, plot2);
        plot2.setMeterAngle(22);
        assertEquals(plot1, plot2);

    }

    /**
     * Confirm that cloning works.
     */
    @Test
    public void testCloning() throws CloneNotSupportedException {
        MeterPlot p1 = new MeterPlot();
        MeterPlot p2 = (MeterPlot) p1.clone();
        assertNotSame(p1, p2);
        assertSame(p1.getClass(), p2.getClass());
        assertEquals(p1, p2);

        // the clone and the original share a reference to the SAME dataset
        assertSame(p1.getDataset(), p2.getDataset());

        // try a few checks to ensure that the clone is independent of the
        // original
        p1.getTickLabelFormat().setMinimumIntegerDigits(99);
        assertNotEquals(p1, p2);
        p2.getTickLabelFormat().setMinimumIntegerDigits(99);
        assertEquals(p1, p2);

        p1.addInterval(new MeterInterval("Test", new Range(1.234, 5.678)));
        assertNotEquals(p1, p2);
        p2.addInterval(new MeterInterval("Test", new Range(1.234, 5.678)));
        assertEquals(p1, p2);

    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    @Test
    public void testSerialization1() {
        MeterPlot p1 = new MeterPlot(null);
        p1.setDialBackgroundPaint(new GradientPaint(1.0f, 2.0f, Color.RED,
                3.0f, 4.0f, Color.BLUE));
        p1.setDialOutlinePaint(new GradientPaint(4.0f, 3.0f, Color.RED,
                2.0f, 1.0f, Color.BLUE));
        p1.setNeedlePaint(new GradientPaint(1.0f, 2.0f, Color.RED,
                3.0f, 4.0f, Color.BLUE));
        p1.setTickLabelPaint(new GradientPaint(1.0f, 2.0f, Color.RED,
                3.0f, 4.0f, Color.BLUE));
        p1.setTickPaint(new GradientPaint(1.0f, 2.0f, Color.RED,
                3.0f, 4.0f, Color.BLUE));
        MeterPlot p2 = TestUtils.serialised(p1);
        assertEquals(p1, p2);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    @Test
    public void testSerialization2() {
        MeterPlot p1 = new MeterPlot(new DefaultValueDataset(1.23));
        MeterPlot p2 = TestUtils.serialised(p1);
        assertEquals(p1, p2);

    }

    /**
     * Tests the calculateTickEndpoints method with various values to ensure
     * coordinate calculations are correct. This test targets surviving mutants
     * in the tick endpoint calculation logic.
     */
    @Test
    public void testCalculateTickEndpoints() {
        MeterPlot plot = new MeterPlot();
        plot.setRange(new Range(0.0, 100.0));
        plot.setMeterAngle(270); // Default angle
        
        // Create a test meter area
        java.awt.geom.Rectangle2D meterArea = new java.awt.geom.Rectangle2D.Double(
                100, 100, 200, 200);
        
        // Test with value at minimum (0)
        TickEndpoints endpoints1 = plot.calculateTickEndpoints(meterArea, 0.0);
        assertNotNull(endpoints1);
        
        // Test with value at midpoint (50)
        TickEndpoints endpoints2 = plot.calculateTickEndpoints(meterArea, 50.0);
        assertNotNull(endpoints2);
        
        // Test with value at maximum (100)
        TickEndpoints endpoints3 = plot.calculateTickEndpoints(meterArea, 100.0);
        assertNotNull(endpoints3);
        
        // The outer and inner endpoints should be different
        assertNotEquals(endpoints1.getX1(), endpoints1.getX2());
        assertNotEquals(endpoints1.getY1(), endpoints1.getY2());
        
        // Different values should produce different endpoints
        assertFalse(endpoints1.getX1() == endpoints2.getX1() 
                && endpoints1.getY1() == endpoints2.getY1());
        assertFalse(endpoints2.getX1() == endpoints3.getX1() 
                && endpoints2.getY1() == endpoints3.getY1());
    }
    
    /**
     * Tests calculateTickEndpoints for specific angle calculations to verify
     * the mathematical operations. This targets MathMutator survivors.
     */
    @Test
    public void testCalculateTickEndpointsAngles() {
        MeterPlot plot = new MeterPlot();
        plot.setRange(new Range(0.0, 100.0));
        plot.setMeterAngle(270);
        
        java.awt.geom.Rectangle2D meterArea = new java.awt.geom.Rectangle2D.Double(
                0, 0, 100, 100);
        
        double centerX = meterArea.getCenterX(); // 50
        double centerY = meterArea.getCenterY(); // 50
        double radius = (meterArea.getWidth() / 2) + MeterPlot.DEFAULT_BORDER_SIZE; // 53
        double radius1 = radius - 15; // 38
        
        // Test at value 0 (should be at rightmost position due to valueToAngle)
        double angle0 = plot.valueToAngle(0.0);
        TickEndpoints endpoints0 = plot.calculateTickEndpoints(meterArea, 0.0);
        
        double expectedX1_0 = centerX + (radius * Math.cos(Math.PI * (angle0 / 180)));
        double expectedY1_0 = centerY - (radius * Math.sin(Math.PI * (angle0 / 180)));
        double expectedX2_0 = centerX + (radius1 * Math.cos(Math.PI * (angle0 / 180)));
        double expectedY2_0 = centerY - (radius1 * Math.sin(Math.PI * (angle0 / 180)));
        
        assertEquals(expectedX1_0, endpoints0.getX1(), 0.001);
        assertEquals(expectedY1_0, endpoints0.getY1(), 0.001);
        assertEquals(expectedX2_0, endpoints0.getX2(), 0.001);
        assertEquals(expectedY2_0, endpoints0.getY2(), 0.001);
        
        // Test at value 100 (should be at leftmost position)
        double angle100 = plot.valueToAngle(100.0);
        TickEndpoints endpoints100 = plot.calculateTickEndpoints(meterArea, 100.0);
        
        double expectedX1_100 = centerX + (radius * Math.cos(Math.PI * (angle100 / 180)));
        double expectedY1_100 = centerY - (radius * Math.sin(Math.PI * (angle100 / 180)));
        double expectedX2_100 = centerX + (radius1 * Math.cos(Math.PI * (angle100 / 180)));
        double expectedY2_100 = centerY - (radius1 * Math.sin(Math.PI * (angle100 / 180)));
        
        assertEquals(expectedX1_100, endpoints100.getX1(), 0.001);
        assertEquals(expectedY1_100, endpoints100.getY1(), 0.001);
        assertEquals(expectedX2_100, endpoints100.getX2(), 0.001);
        assertEquals(expectedY2_100, endpoints100.getY2(), 0.001);
    }
    
    /**
     * Tests calculateTickEndpoints with different meter angles to ensure
     * calculations work correctly for various dial configurations.
     */
    @Test
    public void testCalculateTickEndpointsDifferentAngles() {
        java.awt.geom.Rectangle2D meterArea = new java.awt.geom.Rectangle2D.Double(
                0, 0, 100, 100);
        
        // Test with 180 degree meter angle
        MeterPlot plot180 = new MeterPlot();
        plot180.setRange(new Range(0.0, 100.0));
        plot180.setMeterAngle(180);
        
        TickEndpoints endpoints180_0 = plot180.calculateTickEndpoints(meterArea, 0.0);
        TickEndpoints endpoints180_50 = plot180.calculateTickEndpoints(meterArea, 50.0);
        TickEndpoints endpoints180_100 = plot180.calculateTickEndpoints(meterArea, 100.0);
        
        assertNotNull(endpoints180_0);
        assertNotNull(endpoints180_50);
        assertNotNull(endpoints180_100);
        
        // Verify different values produce different endpoints
        assertFalse(endpoints180_0.equals(endpoints180_50));
        assertFalse(endpoints180_50.equals(endpoints180_100));
        
        // Test with 90 degree meter angle
        MeterPlot plot90 = new MeterPlot();
        plot90.setRange(new Range(0.0, 100.0));
        plot90.setMeterAngle(90);
        
        TickEndpoints endpoints90_0 = plot90.calculateTickEndpoints(meterArea, 0.0);
        TickEndpoints endpoints90_100 = plot90.calculateTickEndpoints(meterArea, 100.0);
        
        assertNotNull(endpoints90_0);
        assertNotNull(endpoints90_100);
        assertFalse(endpoints90_0.equals(endpoints90_100));
    }
    
    /**
     * Tests valueToAngle method comprehensively to ensure angle calculations
     * are correct. This targets surviving mutants in the value-to-angle conversion.
     */
    @Test
    public void testValueToAngle() {
        MeterPlot plot = new MeterPlot();
        plot.setRange(new Range(0.0, 100.0));
        plot.setMeterAngle(270);
        
        // With meterAngle=270, baseAngle = 180 + ((270-180)/2) = 225
        // At minimum value (0), angle = 225 - 0 = 225
        double angle0 = plot.valueToAngle(0.0);
        assertEquals(225.0, angle0, 0.001);
        
        // At midpoint (50), angle = 225 - ((50/100)*270) = 225 - 135 = 90
        double angle50 = plot.valueToAngle(50.0);
        assertEquals(90.0, angle50, 0.001);
        
        // At maximum value (100), angle = 225 - 270 = -45
        double angle100 = plot.valueToAngle(100.0);
        assertEquals(-45.0, angle100, 0.001);
        
        // Test with different range - the angles should still be the same
        plot.setRange(new Range(50.0, 150.0));
        double angleMin = plot.valueToAngle(50.0);
        double angleMax = plot.valueToAngle(150.0);
        assertEquals(225.0, angleMin, 0.001);
        assertEquals(-45.0, angleMax, 0.001);
    }
    
    /**
     * Tests valueToAngle with various meter angles to verify the calculation
     * formula works correctly for different dial configurations.
     */
    @Test
    public void testValueToAngleWithDifferentMeterAngles() {
        MeterPlot plot = new MeterPlot();
        plot.setRange(new Range(0.0, 100.0));
        
        // Test with 180 degree meter: baseAngle = 180 + ((180-180)/2) = 180
        plot.setMeterAngle(180);
        double angle0_180 = plot.valueToAngle(0.0);
        double angle100_180 = plot.valueToAngle(100.0);
        assertEquals(180.0, angle0_180, 0.001); // 180 - 0
        assertEquals(0.0, angle100_180, 0.001);  // 180 - 180
        
        // Test with 90 degree meter: baseAngle = 180 + ((90-180)/2) = 135
        plot.setMeterAngle(90);
        double angle0_90 = plot.valueToAngle(0.0);
        double angle100_90 = plot.valueToAngle(100.0);
        assertEquals(135.0, angle0_90, 0.001);  // 135 - 0
        assertEquals(45.0, angle100_90, 0.001); // 135 - 90
        
        // Test with 360 degree meter: baseAngle = 180 + ((360-180)/2) = 270
        plot.setMeterAngle(360);
        double angle0_360 = plot.valueToAngle(0.0);
        double angle50_360 = plot.valueToAngle(50.0);
        double angle100_360 = plot.valueToAngle(100.0);
        assertEquals(270.0, angle0_360, 0.001); // 270 - 0
        assertEquals(90.0, angle50_360, 0.001);  // 270 - 180
        assertEquals(-90.0, angle100_360, 0.001); // 270 - 360
    }

}
