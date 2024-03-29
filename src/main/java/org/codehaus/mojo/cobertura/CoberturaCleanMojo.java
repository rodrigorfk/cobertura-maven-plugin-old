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

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * Clean up rogue files that cobertura maven plugin is tracking.
 *
 * @author <a href="mailto:joakim@erdfelt.com">Joakim Erdfelt</a>
 * @goal clean
 * @phase clean
 */
public class CoberturaCleanMojo
    extends AbstractCoberturaMojo
{
    /**
     * Mojo main entry
     *
     * @throws MojoExecutionException
     */
    public void execute()
        throws MojoExecutionException, MojoFailureException
    {
        if ( skipMojo() )
        {
            return;
        }

        if ( getDataFile().exists() )
        {
            getDataFile().delete();
        }
    }
}
