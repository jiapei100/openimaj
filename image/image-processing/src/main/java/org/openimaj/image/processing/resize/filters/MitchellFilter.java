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
package org.openimaj.image.processing.resize.filters;

import org.openimaj.image.processing.resize.ResizeFilterFunction;

/**
 * Mitchell filter for the resample function.
 * 
 * @author David Dupplaw (dpd@ecs.soton.ac.uk)
 * 
 */
public class MitchellFilter implements ResizeFilterFunction
{
	/**
	 * The singleton instance of the filter
	 */
	public static ResizeFilterFunction INSTANCE = new MitchellFilter();

	/**
	 * Returns the defaultSupport
	 * 
	 * @return the defaultSupport
	 */
	@Override
	public double getSupport()
	{
		return 2;
	}

	/**
	 * @see ResizeFilterFunction#filter(double)
	 */
	@Override
	public double filter(double t)
	{
		double B, C;
		B = C = 1d / 3d;

		double tt;

		tt = t * t;
		if (t < 0)
			t = -t;
		if (t < 1.0)
		{
			t = (((12.0 - 9.0 * B - 6.0 * C) * (t * tt)) + ((-18.0 + 12.0 * B + 6.0 * C) * tt) + (6.0 - 2 * B));
			return (t / 6.0);
		}
		else if (t < 2.0)
		{
			t = (((-1.0 * B - 6.0 * C) * (t * tt)) + ((6.0 * B + 30.0 * C) * tt) + ((-12.0 * B - 48.0 * C) * t) + (8.0 * B + 24 * C));
			return (t / 6.0);
		}
		return (0.0);
	}
}
