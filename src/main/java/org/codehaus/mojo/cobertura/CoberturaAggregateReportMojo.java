/*
 * #%L
 * Mojo's Maven plugin for Cobertura
 * %%
 * Copyright (C) 2005 - 2013 Codehaus
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
package org.codehaus.mojo.cobertura;

import java.util.Locale;
import org.apache.maven.reporting.MavenReportException;

/**
 *
 * Instruments, Tests, and only Generates a Cobertura Report as an aggregated report.
 * 
 * @author <a href="http://github.com/rodrigorfk">rodrigokuntzer</a>
 * @goal aggregate-report
 * @execute phase="" lifecycle="cobertura"
 */
public class CoberturaAggregateReportMojo
    extends CoberturaReportMojo
{
    
    /**
     * @param locale not used
     * @throws MavenReportException when an exception occurs
     * @see org.apache.maven.reporting.AbstractMavenReport#executeReport(java.util.Locale)
     */
    @Override
    protected void executeReport( Locale locale )
        throws MavenReportException
    {
        if ( canGenerateAggregateReports() )
        {
            executeAggregateReport( locale );
        }
    }
    
}
