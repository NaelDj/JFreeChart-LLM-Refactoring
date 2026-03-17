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
 * Pie3DPlotTest.java
 * ------------------
 * (C) Copyright 2003-present, by David Gilbert and Contributors.
 *
 * Original Author:  David Gilbert;
 * Contributor(s):   -;
 *
 */

package org.jfree.chart.plot;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the {@link PiePlot3D} class.
 */
public class PiePlot3DTest {

    /**
     * Some checks for the equals() method.
     */
    @Test
    public void testEquals() {
        PiePlot3D p1 = new PiePlot3D();
        PiePlot3D p2 = new PiePlot3D();
        assertEquals(p1, p2);
        assertEquals(p2, p1);

        p1.setDepthFactor(1.23);
        assertNotEquals(p1, p2);
        p2.setDepthFactor(1.23);
        assertEquals(p1, p2);

        p1.setDarkerSides(true);
        assertNotEquals(p1, p2);
        p2.setDarkerSides(true);
        assertEquals(p1, p2);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    @Test
    public void testSerialization() {
        PiePlot3D p1 = new PiePlot3D(null);
        PiePlot3D p2 = (PiePlot3D) TestUtils.serialised(p1);
        assertEquals(p1, p2);
    }

    /**
     * Draws a pie chart where the label generator returns null.
     */
    @Test
    public void testDrawWithNullDataset() {
        JFreeChart chart = ChartFactory.createPieChart3D("Test", null, true,
                false, false);
        boolean success = false;
        try {
            BufferedImage image = new BufferedImage(200 , 100,
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = image.createGraphics();
            chart.draw(g2, new Rectangle2D.Double(0, 0, 200, 100), null, null);
            g2.dispose();
            success = true;
        }
        catch (Exception e) {
            success = false;
        }
        assertTrue(success);
    }

    /**
     * Tests the isAngleAtFront() method with various angles.
     * This test targets surviving mutants in the angle detection logic.
     * Note: Due to floating-point precision, sin(180°) and sin(360°) may not be exactly 0.
     */
    @Test
    public void testIsAngleAtFront() {
        PiePlot3D plot = new PiePlot3D();
        
        // Test angles in the back range (0-180 degrees where sin > 0)
        // These should all return false (at back, not front)
        assertFalse(plot.isAngleAtFront(0.0), "0 degrees is boundary (sin=0)");
        assertFalse(plot.isAngleAtFront(45.0), "45 degrees should not be at front");
        assertFalse(plot.isAngleAtFront(90.0), "90 degrees should not be at front");
        assertFalse(plot.isAngleAtFront(135.0), "135 degrees should not be at front");
        assertFalse(plot.isAngleAtFront(179.0), "179 degrees should not be at front");
        
        // Test angles in the front range (180-360 degrees where sin < 0)
        // These should all return true (at front)
        assertTrue(plot.isAngleAtFront(181.0), "181 degrees should be at front");
        assertTrue(plot.isAngleAtFront(225.0), "225 degrees should be at front");
        assertTrue(plot.isAngleAtFront(270.0), "270 degrees should be at front");
        assertTrue(plot.isAngleAtFront(315.0), "315 degrees should be at front");
        assertTrue(plot.isAngleAtFront(359.0), "359 degrees should be at front");
        
        // Test near-boundary angles (floating-point precision affects exact boundaries)
        // 180° and 360° may return true/false depending on floating-point representation
        boolean result180 = plot.isAngleAtFront(180.0);
        boolean result360 = plot.isAngleAtFront(360.0);
        // Just verify they are not both true for angles near each other
        assertTrue(!result180 || !plot.isAngleAtBack(180.0), 
            "180 degrees should not be both at front and back");
        assertTrue(!result360 || !plot.isAngleAtBack(360.0), 
            "360 degrees should not be both at front and back");
    }

    /**
     * Tests the isAngleAtBack() method with various angles.
     * This test targets surviving mutants in the angle detection logic.
     * Note: Due to floating-point precision, sin(180°) and sin(360°) may not be exactly 0.
     */
    @Test
    public void testIsAngleAtBack() {
        PiePlot3D plot = new PiePlot3D();
        
        // Test angles in the back range (0-180 degrees where sin > 0)
        // These should all return true (at back)
        assertFalse(plot.isAngleAtBack(0.0), "0 degrees is boundary (sin=0)");
        assertTrue(plot.isAngleAtBack(1.0), "1 degree should be at back");
        assertTrue(plot.isAngleAtBack(45.0), "45 degrees should be at back");
        assertTrue(plot.isAngleAtBack(90.0), "90 degrees should be at back");
        assertTrue(plot.isAngleAtBack(135.0), "135 degrees should be at back");
        assertTrue(plot.isAngleAtBack(179.0), "179 degrees should be at back");
        
        // Test angles in the front range (180-360 degrees where sin < 0)
        // These should all return false (at front, not back)
        assertFalse(plot.isAngleAtBack(181.0), "181 degrees should be at front");
        assertFalse(plot.isAngleAtBack(225.0), "225 degrees should be at front");
        assertFalse(plot.isAngleAtBack(270.0), "270 degrees should be at front");
        assertFalse(plot.isAngleAtBack(315.0), "315 degrees should be at front");
        assertFalse(plot.isAngleAtBack(359.0), "359 degrees should be at front");
        
        // Test near-boundary angles (floating-point precision affects exact boundaries)
        boolean result180 = plot.isAngleAtBack(180.0);
        boolean result360 = plot.isAngleAtBack(360.0);
        // Just verify they are not both true for angles near each other
        assertTrue(!result180 || !plot.isAngleAtFront(180.0), 
            "180 degrees should not be both at front and back");
        assertTrue(!result360 || !plot.isAngleAtFront(360.0), 
            "360 degrees should not be both at front and back");
    }

    /**
     * Tests that isAngleAtFront and isAngleAtBack are complementary
     * for angles in the valid range.
     */
    @Test
    public void testAngleFrontBackComplementary() {
        PiePlot3D plot = new PiePlot3D();
        
        // For most angles, exactly one should be true (except at boundaries)
        // At boundaries (0, 180, 360), both might be false (sin = 0)
        for (int angle = 1; angle < 360; angle += 10) {
            boolean atFront = plot.isAngleAtFront(angle);
            boolean atBack = plot.isAngleAtBack(angle);
            
            // For angles not at exact boundaries, they should be complementary
            if (angle != 0 && angle != 180 && angle != 360) {
                assertTrue(atFront != atBack, 
                    "Angle " + angle + " should be either at front or back, not both or neither");
            }
        }
    }

    /**
     * Tests that getModifiedPaintForSides() returns the original paint when
     * darkerSides is false. This targets surviving mutants related to the
     * paint modification logic.
     */
    @Test
    public void testGetModifiedPaintForSides_WithDarkerSidesDisabled() {
        PiePlot3D plot = new PiePlot3D();
        plot.setDarkerSides(false);
        
        java.awt.Color originalColor = java.awt.Color.RED;
        java.awt.Paint result = plot.getModifiedPaintForSides(originalColor);
        
        // When darkerSides is false, should return the original paint unchanged
        assertSame(originalColor, result, 
            "When darkerSides is false, original paint should be returned");
    }

    /**
     * Tests that getModifiedPaintForSides() returns a darker paint when
     * darkerSides is true. This targets surviving mutants related to the
     * paint modification logic.
     */
    @Test
    public void testGetModifiedPaintForSides_WithDarkerSidesEnabled() {
        PiePlot3D plot = new PiePlot3D();
        plot.setDarkerSides(true);
        
        java.awt.Color originalColor = new java.awt.Color(200, 100, 50, 255);
        java.awt.Paint result = plot.getModifiedPaintForSides(originalColor);
        
        // When darkerSides is true, should return a different (darker) paint
        assertNotSame(originalColor, result, 
            "When darkerSides is true, a modified paint should be returned");
        
        // Verify the result is actually a Color (darker paint)
        assertTrue(result instanceof java.awt.Color,
            "Result should be a Color instance");
        
        java.awt.Color resultColor = (java.awt.Color) result;
        
        // Verify that the result is darker (RGB components should be smaller)
        assertTrue(resultColor.getRed() <= originalColor.getRed(),
            "Red component should not increase");
        assertTrue(resultColor.getGreen() <= originalColor.getGreen(),
            "Green component should not increase");
        assertTrue(resultColor.getBlue() <= originalColor.getBlue(),
            "Blue component should not increase");
        
        // At least one component should be strictly smaller (i.e., actually darker)
        boolean isDarker = (resultColor.getRed() < originalColor.getRed()) ||
                          (resultColor.getGreen() < originalColor.getGreen()) ||
                          (resultColor.getBlue() < originalColor.getBlue());
        assertTrue(isDarker, "Result should be darker than original");
    }

    /**
     * Tests that getModifiedPaintForSides() properly handles the darkerSides flag 
     * transition. This ensures the observable behavior changes when the flag is toggled.
     */
    @Test
    public void testGetModifiedPaintForSides_FlagToggle() {
        PiePlot3D plot = new PiePlot3D();
        java.awt.Color testColor = new java.awt.Color(150, 150, 150);
        
        // Initially darkerSides is false
        plot.setDarkerSides(false);
        java.awt.Paint result1 = plot.getModifiedPaintForSides(testColor);
        assertSame(testColor, result1, 
            "With darkerSides=false, should return original");
        
        // Toggle to true
        plot.setDarkerSides(true);
        java.awt.Paint result2 = plot.getModifiedPaintForSides(testColor);
        assertNotSame(testColor, result2, 
            "With darkerSides=true, should return modified paint");
        
        // Toggle back to false
        plot.setDarkerSides(false);
        java.awt.Paint result3 = plot.getModifiedPaintForSides(testColor);
        assertSame(testColor, result3, 
            "After toggling back to false, should return original again");
    }

}
