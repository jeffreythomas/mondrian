/*
// This software is subject to the terms of the Eclipse Public License v1.0
// Agreement, available at the following URL:
// http://www.eclipse.org/legal/epl-v10.html.
// You must accept the terms of that agreement to use this software.
//
// Copyright (C) 2005-2009 Pentaho and others
// All Rights Reserved.
*/
package mondrian.rolap.aggmatcher;

import mondrian.olap.MondrianProperties;
import mondrian.test.loader.CsvDBTestCase;

/**
 * This abstract class can be used as the basis for writing aggregate table
 * test in the "testsrc/main/mondrian/rolap/aggmatcher" directory. Taken care
 * of is the setting of the Caching and Aggregate Read/Use properties and
 * the reloading of the aggregate tables after the CSV tables are loaded.
 * The particular cube definition and CSV file to use are abstract methods.
 *
 * @author <a>Richard M. Emberson</a>
 */
public abstract class AggTableTestCase extends CsvDBTestCase {

    private static final String DIRECTORY =
                            "testsrc/main/mondrian/rolap/aggmatcher";

    public AggTableTestCase() {
        super();
    }
    public AggTableTestCase(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        super.setUp();

        // store current property values
        MondrianProperties props = MondrianProperties.instance();

        // turn off caching
        propSaver.set(
            props.DisableCaching,
            true);
        propSaver.set(
            props.UseAggregates,
            true);
        propSaver.set(
            props.ReadAggregates,
            false);
        propSaver.set(
            props.ReadAggregates,
            true);
    }

    protected String getDirectoryName() {
        return DIRECTORY;
    }
}

// End AggTableTestCase.java
