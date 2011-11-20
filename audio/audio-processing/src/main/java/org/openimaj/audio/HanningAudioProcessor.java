/**
 * Copyright (c) 2011, The University of Southampton and the individual contributors.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 *   * 	Redistributions of source code must retain the above copyright notice,
 * 	this list of conditions and the following disclaimer.
 *
 *   *	Redistributions in binary form must reproduce the above copyright notice,
 * 	this list of conditions and the following disclaimer in the documentation
 * 	and/or other materials provided with the distribution.
 *
 *   *	Neither the name of the University of Southampton nor the names of its
 * 	contributors may be used to endorse or promote products derived from this
 * 	software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
/**
 * 
 */
package org.openimaj.audio;

import java.nio.ShortBuffer;

import org.openimaj.audio.processor.FixedSizeSampleAudioProcessor;

/**
 * 	Applies a Hanning window on top of the audio signal
 * 	@see http://cnx.org/content/m0505/latest/
 * 
 *  @author David Dupplaw <dpd@ecs.soton.ac.uk>
 *	@version $Author$, $Revision$, $Date$
 *	@created 31 Oct 2011
 */
public class HanningAudioProcessor extends FixedSizeSampleAudioProcessor
{
	/**
	 * 
	 *  @param stream
	 *  @param sizeRequired
	 */
	public HanningAudioProcessor( AudioStream stream, int sizeRequired )
    {
	    super( stream, sizeRequired );
    }

	/**
	 *  @inheritDoc
	 *  @see org.openimaj.audio.processor.FixedSizeSampleAudioProcessor#nextSampleChunk()
	 */
	@Override
	public SampleChunk nextSampleChunk()
	{
		SampleChunk sample = super.nextSampleChunk();
		if( sample == null ) return null;
		
		ShortBuffer b = sample.getSamplesAsByteBuffer().asShortBuffer();
		final int nc = sample.getFormat().getNumChannels();
		final int ns = sample.getNumberOfSamples()/nc;
		for( int n = 0; n < ns; n++ )
			for( int c = 0; c < nc; c++ )
				b.put( n*nc+c, (short)(b.get(n*nc+c) * 0.5*(1-Math.cos((2*Math.PI*n)/ns))) );
		
		return sample;
	}
	
	/**
	 * 	The implementation in this class returns the sample as is.
	 * 
	 *  @inheritDoc
	 *  @see org.openimaj.audio.processor.AudioProcessor#process(org.openimaj.audio.SampleChunk)
	 */
	@Override
	public SampleChunk process( SampleChunk sample )
	{
	    return sample;
	}
}