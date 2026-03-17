package org.jfree.chart.plot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class that records drawing operations performed during plot rendering.
 * This enables tests to verify that expected drawing operations occurred.
 */
public class DrawingOperations {
    
    private final List<String> operations;
    private boolean backgroundDrawn;
    private boolean domainGridlinesDrawn;
    private boolean rangeGridlinesDrawn;
    private boolean domainMarkersDrawn;
    private boolean rangeMarkersDrawn;
    private boolean annotationsDrawn;
    
    public DrawingOperations() {
        this.operations = new ArrayList<>();
        this.backgroundDrawn = false;
        this.domainGridlinesDrawn = false;
        this.rangeGridlinesDrawn = false;
        this.domainMarkersDrawn = false;
        this.rangeMarkersDrawn = false;
        this.annotationsDrawn = false;
    }
    
    public void recordBackgroundDrawn() {
        this.backgroundDrawn = true;
        this.operations.add("drawBackground");
    }
    
    public void recordDomainGridlinesDrawn() {
        this.domainGridlinesDrawn = true;
        this.operations.add("drawDomainGridlines");
    }
    
    public void recordRangeGridlinesDrawn() {
        this.rangeGridlinesDrawn = true;
        this.operations.add("drawRangeGridlines");
    }
    
    public void recordDomainMarkersDrawn(int layer) {
        this.domainMarkersDrawn = true;
        this.operations.add("drawDomainMarkers_" + layer);
    }
    
    public void recordRangeMarkersDrawn(int layer) {
        this.rangeMarkersDrawn = true;
        this.operations.add("drawRangeMarkers_" + layer);
    }
    
    public void recordAnnotationsDrawn() {
        this.annotationsDrawn = true;
        this.operations.add("drawAnnotations");
    }
    
    public void recordOperation(String operation) {
        this.operations.add(operation);
    }
    
    public boolean wasBackgroundDrawn() {
        return this.backgroundDrawn;
    }
    
    public boolean wereDomainGridlinesDrawn() {
        return this.domainGridlinesDrawn;
    }
    
    public boolean wereRangeGridlinesDrawn() {
        return this.rangeGridlinesDrawn;
    }
    
    public boolean wereDomainMarkersDrawn() {
        return this.domainMarkersDrawn;
    }
    
    public boolean wereRangeMarkersDrawn() {
        return this.rangeMarkersDrawn;
    }
    
    public boolean wereAnnotationsDrawn() {
        return this.annotationsDrawn;
    }
    
    public List<String> getOperations() {
        return Collections.unmodifiableList(this.operations);
    }
    
    public int getOperationCount() {
        return this.operations.size();
    }
    
    public boolean containsOperation(String operation) {
        return this.operations.contains(operation);
    }
}