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
 * ---------------------
 * CategoryAxisTest.java
 * ---------------------
 * (C) Copyright 2003-present, by David Gilbert and Contributors.
 *
 * Original Author:  David Gilbert;
 * Contributor(s):   -;
 *
 */

package org.jfree.chart.axis;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;

import org.jfree.chart.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the {@link CategoryAxis} class.
 */
public class CategoryAxisTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    @Test
    public void testEquals() {
        CategoryAxis a1 = new CategoryAxis("Test");
        CategoryAxis a2 = new CategoryAxis("Test");
        assertEquals(a1, a2);

        // lowerMargin
        a1.setLowerMargin(0.15);
        assertNotEquals(a1, a2);
        a2.setLowerMargin(0.15);
        assertEquals(a1, a2);

        // upperMargin
        a1.setUpperMargin(0.15);
        assertNotEquals(a1, a2);
        a2.setUpperMargin(0.15);
        assertEquals(a1, a2);

        // categoryMargin
        a1.setCategoryMargin(0.15);
        assertNotEquals(a1, a2);
        a2.setCategoryMargin(0.15);
        assertEquals(a1, a2);

        // maxCategoryLabelWidthRatio
        a1.setMaximumCategoryLabelWidthRatio(0.98f);
        assertNotEquals(a1, a2);
        a2.setMaximumCategoryLabelWidthRatio(0.98f);
        assertEquals(a1, a2);

        // categoryLabelPositionOffset
        a1.setCategoryLabelPositionOffset(11);
        assertNotEquals(a1, a2);
        a2.setCategoryLabelPositionOffset(11);
        assertEquals(a1, a2);

        // categoryLabelPositions
        a1.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
        assertNotEquals(a1, a2);
        a2.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
        assertEquals(a1, a2);

        // categoryLabelToolTips
        a1.addCategoryLabelToolTip("Test", "Check");
        assertNotEquals(a1, a2);
        a2.addCategoryLabelToolTip("Test", "Check");
        assertEquals(a1, a2);

        // categoryLabelURLs
        a1.addCategoryLabelURL("Test", "https://www.jfree.org/");
        assertNotEquals(a1, a2);
        a2.addCategoryLabelURL("Test", "https://www.jfree.org/");
        assertEquals(a1, a2);

        // tickLabelFont
        a1.setTickLabelFont("C1", new Font("Dialog", Font.PLAIN, 21));
        assertNotEquals(a1, a2);
        a2.setTickLabelFont("C1", new Font("Dialog", Font.PLAIN, 21));
        assertEquals(a1, a2);

        // tickLabelPaint
        a1.setTickLabelPaint("C1", Color.RED);
        assertNotEquals(a1, a2);
        a2.setTickLabelPaint("C1", Color.RED);
        assertEquals(a1, a2);

        // tickLabelPaint2
        a1.setTickLabelPaint("C1", new GradientPaint(1.0f, 2.0f, Color.RED,
                3.0f, 4.0f, Color.YELLOW));
        assertNotEquals(a1, a2);
        a2.setTickLabelPaint("C1", new GradientPaint(1.0f, 2.0f, Color.RED,
                3.0f, 4.0f, Color.YELLOW));
        assertEquals(a1, a2);

    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    @Test
    public void testHashCode() {
        CategoryAxis a1 = new CategoryAxis("Test");
        CategoryAxis a2 = new CategoryAxis("Test");
        assertEquals(a1, a2);
        int h1 = a1.hashCode();
        int h2 = a2.hashCode();
        assertEquals(h1, h2);
    }

    /**
     * Confirm that cloning works.
     */
    @Test
    public void testCloning() throws CloneNotSupportedException {
        CategoryAxis a1 = new CategoryAxis("Test");
        CategoryAxis a2 = (CategoryAxis) a1.clone();
        assertNotSame(a1, a2);
        assertSame(a1.getClass(), a2.getClass());
        assertEquals(a1, a2);
    }

    /**
     * Confirm that cloning works.  This test customises the font and paint
     * per category label.
     */
    @Test
    public void testCloning2() throws CloneNotSupportedException {
        CategoryAxis a1 = new CategoryAxis("Test");
        a1.setTickLabelFont("C1", new Font("Dialog", Font.PLAIN, 15));
        a1.setTickLabelPaint("C1", new GradientPaint(1.0f, 2.0f, Color.RED,
                3.0f, 4.0f, Color.WHITE));
        CategoryAxis a2 = (CategoryAxis) a1.clone();
        assertNotSame(a1, a2);
        assertSame(a1.getClass(), a2.getClass());
        assertEquals(a1, a2);

        // check that changing a tick label font in a1 doesn't change a2
        a1.setTickLabelFont("C1", null);
        assertNotEquals(a1, a2);
        a2.setTickLabelFont("C1", null);
        assertEquals(a1, a2);

        // check that changing a tick label paint in a1 doesn't change a2
        a1.setTickLabelPaint("C1", Color.YELLOW);
        assertNotEquals(a1, a2);
        a2.setTickLabelPaint("C1", Color.YELLOW);
        assertEquals(a1, a2);

        // check that changing a category label tooltip in a1 doesn't change a2
        a1.addCategoryLabelToolTip("C1", "XYZ");
        assertNotEquals(a1, a2);
        a2.addCategoryLabelToolTip("C1", "XYZ");
        assertEquals(a1, a2);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    @Test
    public void testSerialization() {
        CategoryAxis a1 = new CategoryAxis("Test Axis");
        a1.setTickLabelPaint("C1", new GradientPaint(1.0f, 2.0f, Color.RED,
                3.0f, 4.0f, Color.WHITE));
        CategoryAxis a2 = TestUtils.serialised(a1);
        assertEquals(a1, a2);
    }

    /**
     * Test calculateCategoryLabelBounds for BOTTOM edge.
     * This test targets arithmetic mutants in coordinate calculations (lines 970, 978).
     */
    @Test
    public void testCalculateCategoryLabelBoundsBottom() {
        CategoryAxis axis = new CategoryAxis("Test");
        axis.setCategoryLabelPositionOffset(10);
        
        java.awt.geom.Rectangle2D dataArea = new java.awt.geom.Rectangle2D.Double(
                100.0, 200.0, 400.0, 300.0);
        AxisState state = new AxisState(250.0);
        state.setMax(50.0);  // Maximum label height
        
        // Calculate bounds for first category (index 0) out of 3 categories
        CategoryLabelBounds bounds = axis.calculateCategoryLabelBounds(
                0, 3, dataArea, org.jfree.chart.ui.RectangleEdge.BOTTOM, state);
        
        // For BOTTOM edge:
        // x0 = getCategoryStart(0, 3, dataArea, BOTTOM)
        // x1 = getCategoryEnd(0, 3, dataArea, BOTTOM)
        // y0 = cursor + offset = 250 + 10 = 260
        // y1 = y0 + max = 260 + 50 = 310
        
        double expectedX0 = axis.getCategoryStart(0, 3, dataArea, 
                org.jfree.chart.ui.RectangleEdge.BOTTOM);
        double expectedX1 = axis.getCategoryEnd(0, 3, dataArea, 
                org.jfree.chart.ui.RectangleEdge.BOTTOM);
        double expectedY0 = 250.0 + 10.0;  // cursor + offset
        double expectedY1 = 260.0 + 50.0;  // y0 + max
        
        assertEquals(expectedX0, bounds.getX0(), 0.0001);
        assertEquals(expectedX1, bounds.getX1(), 0.0001);
        assertEquals(expectedY0, bounds.getY0(), 0.0001);
        assertEquals(expectedY1, bounds.getY1(), 0.0001);
    }

    /**
     * Test calculateCategoryLabelBounds for TOP edge.
     * This test targets arithmetic mutants in coordinate calculations (lines 971, 979).
     */
    @Test
    public void testCalculateCategoryLabelBoundsTop() {
        CategoryAxis axis = new CategoryAxis("Test");
        axis.setCategoryLabelPositionOffset(10);
        
        java.awt.geom.Rectangle2D dataArea = new java.awt.geom.Rectangle2D.Double(
                100.0, 200.0, 400.0, 300.0);
        AxisState state = new AxisState(250.0);
        state.setMax(50.0);
        
        CategoryLabelBounds bounds = axis.calculateCategoryLabelBounds(
                1, 3, dataArea, org.jfree.chart.ui.RectangleEdge.TOP, state);
        
        // For TOP edge:
        // x0 = getCategoryStart(1, 3, dataArea, TOP)
        // x1 = getCategoryEnd(1, 3, dataArea, TOP)
        // y1 = cursor - offset = 250 - 10 = 240
        // y0 = y1 - max = 240 - 50 = 190
        
        double expectedX0 = axis.getCategoryStart(1, 3, dataArea, 
                org.jfree.chart.ui.RectangleEdge.TOP);
        double expectedX1 = axis.getCategoryEnd(1, 3, dataArea, 
                org.jfree.chart.ui.RectangleEdge.TOP);
        double expectedY1 = 250.0 - 10.0;  // cursor - offset
        double expectedY0 = 240.0 - 50.0;  // y1 - max
        
        assertEquals(expectedX0, bounds.getX0(), 0.0001);
        assertEquals(expectedX1, bounds.getX1(), 0.0001);
        assertEquals(expectedY0, bounds.getY0(), 0.0001);
        assertEquals(expectedY1, bounds.getY1(), 0.0001);
    }

    /**
     * Test calculateCategoryLabelBounds for LEFT edge.
     * This test verifies label bounds calculation for vertical axis.
     */
    @Test
    public void testCalculateCategoryLabelBoundsLeft() {
        CategoryAxis axis = new CategoryAxis("Test");
        axis.setCategoryLabelPositionOffset(15);
        
        java.awt.geom.Rectangle2D dataArea = new java.awt.geom.Rectangle2D.Double(
                100.0, 200.0, 400.0, 300.0);
        AxisState state = new AxisState(150.0);
        state.setMax(60.0);  // Maximum label width
        
        CategoryLabelBounds bounds = axis.calculateCategoryLabelBounds(
                2, 4, dataArea, org.jfree.chart.ui.RectangleEdge.LEFT, state);
        
        // For LEFT edge:
        // y0 = getCategoryStart(2, 4, dataArea, LEFT)
        // y1 = getCategoryEnd(2, 4, dataArea, LEFT)
        // x1 = cursor - offset = 150 - 15 = 135
        // x0 = x1 - max = 135 - 60 = 75
        
        double expectedY0 = axis.getCategoryStart(2, 4, dataArea, 
                org.jfree.chart.ui.RectangleEdge.LEFT);
        double expectedY1 = axis.getCategoryEnd(2, 4, dataArea, 
                org.jfree.chart.ui.RectangleEdge.LEFT);
        double expectedX1 = 150.0 - 15.0;  // cursor - offset
        double expectedX0 = 135.0 - 60.0;  // x1 - max
        
        assertEquals(expectedX0, bounds.getX0(), 0.0001);
        assertEquals(expectedX1, bounds.getX1(), 0.0001);
        assertEquals(expectedY0, bounds.getY0(), 0.0001);
        assertEquals(expectedY1, bounds.getY1(), 0.0001);
    }

    /**
     * Test calculateCategoryLabelBounds for RIGHT edge.
     * This test targets arithmetic mutants in RIGHT edge calculations.
     */
    @Test
    public void testCalculateCategoryLabelBoundsRight() {
        CategoryAxis axis = new CategoryAxis("Test");
        axis.setCategoryLabelPositionOffset(8);
        
        java.awt.geom.Rectangle2D dataArea = new java.awt.geom.Rectangle2D.Double(
                50.0, 100.0, 300.0, 400.0);
        AxisState state = new AxisState(200.0);
        state.setMax(40.0);
        
        CategoryLabelBounds bounds = axis.calculateCategoryLabelBounds(
                0, 2, dataArea, org.jfree.chart.ui.RectangleEdge.RIGHT, state);
        
        // For RIGHT edge:
        // y0 = getCategoryStart(0, 2, dataArea, RIGHT)
        // y1 = getCategoryEnd(0, 2, dataArea, RIGHT)
        // x0 = cursor + offset = 200 + 8 = 208
        // x1 = x0 - max = 208 - 40 = 168  (NOTE: this seems like incorrect logic in original code)
        
        double expectedY0 = axis.getCategoryStart(0, 2, dataArea, 
                org.jfree.chart.ui.RectangleEdge.RIGHT);
        double expectedY1 = axis.getCategoryEnd(0, 2, dataArea, 
                org.jfree.chart.ui.RectangleEdge.RIGHT);
        double expectedX0 = 200.0 + 8.0;   // cursor + offset
        double expectedX1 = 208.0 - 40.0;  // x0 - max
        
        assertEquals(expectedX0, bounds.getX0(), 0.0001);
        assertEquals(expectedX1, bounds.getX1(), 0.0001);
        assertEquals(expectedY0, bounds.getY0(), 0.0001);
        assertEquals(expectedY1, bounds.getY1(), 0.0001);
    }

    /**
     * Test that CategoryLabelBounds correctly converts to Rectangle2D.
     */
    @Test
    public void testCategoryLabelBoundsToRectangle() {
        CategoryLabelBounds bounds = new CategoryLabelBounds(10.0, 50.0, 20.0, 80.0);
        java.awt.geom.Rectangle2D rect = bounds.toRectangle();
        
        assertEquals(10.0, rect.getX(), 0.0001);
        assertEquals(20.0, rect.getY(), 0.0001);
        assertEquals(40.0, rect.getWidth(), 0.0001);  // x1 - x0 = 50 - 10
        assertEquals(60.0, rect.getHeight(), 0.0001); // y1 - y0 = 80 - 20
    }

    /**
     * Test calculateCategoryLabelBounds with different margins.
     * This ensures the coordinate calculations handle margin settings correctly.
     */
    @Test
    public void testCalculateCategoryLabelBoundsWithMargins() {
        CategoryAxis axis = new CategoryAxis("Test");
        axis.setLowerMargin(0.1);
        axis.setUpperMargin(0.1);
        axis.setCategoryMargin(0.3);
        axis.setCategoryLabelPositionOffset(5);
        
        java.awt.geom.Rectangle2D dataArea = new java.awt.geom.Rectangle2D.Double(
                0.0, 0.0, 500.0, 200.0);
        AxisState state = new AxisState(100.0);
        state.setMax(30.0);
        
        // Test middle category to ensure gap calculations are correct
        CategoryLabelBounds bounds = axis.calculateCategoryLabelBounds(
                1, 3, dataArea, org.jfree.chart.ui.RectangleEdge.BOTTOM, state);
        
        // Verify bounds are within data area and properly positioned
        assertTrue(bounds.getX0() >= 0.0);
        assertTrue(bounds.getX1() <= 500.0);
        assertTrue(bounds.getX0() < bounds.getX1());
        
        // Verify Y coordinates match expected calculation
        assertEquals(105.0, bounds.getY0(), 0.0001);  // cursor + offset
        assertEquals(135.0, bounds.getY1(), 0.0001);  // y0 + max
    }

}
