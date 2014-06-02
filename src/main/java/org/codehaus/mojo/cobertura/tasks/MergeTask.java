/*
 * Copyright 2014 Codehaus.
 *
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
 */
package org.codehaus.mojo.cobertura.tasks;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.maven.plugin.MojoExecutionException;

/**
 *
 * @author rodrigokuntzer
 */
public class MergeTask extends AbstractTask
{
    private File dataFile;
    
    private List<File> intermediateDatafiles = new ArrayList<File>();

    public MergeTask()
    {
        super( "net.sourceforge.cobertura.merge.Main" );
    }

    @Override
    public void execute() throws MojoExecutionException
    {

        if ( dataFile != null )
        {
            cmdLineArgs.addArg( "--datafile", dataFile.getAbsolutePath() );
        }
        
        for ( File intermediateDataFile : intermediateDatafiles )
        {
            cmdLineArgs.addArg( intermediateDataFile.getAbsolutePath() );
        }

        int returnCode = executeJava();

        // Check the return code and print a message
        if ( returnCode == 0 )
        {
            getLog().info( "Cobertura Merge was successful." );
        }
        else
        {
            throw new MojoExecutionException( "Unable to generate Cobertura Merge for project." );
        }
    }

    public File getDataFile()
    {
        return dataFile;
    }

    public void setDataFile( File dataFile )
    {
        this.dataFile = dataFile;
    }

    public List<File> getIntermediateDatafiles()
    {
        return intermediateDatafiles;
    }

    public void setIntermediateDatafiles( List<File> intermediateDatafiles )
    {
        this.intermediateDatafiles = intermediateDatafiles;
    }

    
}
