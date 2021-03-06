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
package org.openimaj.video.gstreamer;

import org.bridj.BridJ;
import org.bridj.Platform;
import org.bridj.Pointer;
import org.bridj.ann.Library;
import org.bridj.ann.Runtime;
import org.bridj.cpp.CPPObject;
import org.bridj.cpp.CPPRuntime;

/**
 * <i>native declaration : line 24</i><br>
 * This file was autogenerated by <a
 * href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a
 * href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few
 * opensource projects.</a>.<br>
 * For help, please visit <a
 * href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a
 * href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("OpenIMAJGStreamer")
@Runtime(CPPRuntime.class)
@SuppressWarnings("all")
class OpenIMAJCapGStreamer extends CPPObject {
	static {
		Platform.addEmbeddedLibraryResourceRoot("org/openimaj/video/gstreamer/nativelib/");
		BridJ.register();
	}

	public static final int PROP_POS_MSEC = 0;
	public static final int PROP_POS_FRAMES = 1;
	public static final int PROP_POS_AVI_RATIO = 2;
	public static final int PROP_FRAME_WIDTH = 3;
	public static final int PROP_FRAME_HEIGHT = 4;
	public static final int PROP_FPS = 5;
	public static final int GSTREAMER_QUEUE_LENGTH = 200;

	public OpenIMAJCapGStreamer() {
		super();
	}

	/**
	 * Original signature : <code>bool open(const char*)</code><br>
	 * <i>native declaration : line 30</i>
	 */
	native public boolean open(Pointer<Byte> filename);

	/**
	 * Original signature : <code>void close()</code><br>
	 * <i>native declaration : line 31</i>
	 */
	native public void close();

	/**
	 * Original signature : <code>double getProperty(int)</code><br>
	 * <i>native declaration : line 33</i>
	 */
	native public double getProperty(int int1);

	/**
	 * Original signature : <code>bool setProperty(int, double)</code><br>
	 * <i>native declaration : line 34</i>
	 */
	native public boolean setProperty(int int1, double double1);

	/**
	 * Original signature : <code>bool nextFrame()</code><br>
	 * <i>native declaration : line 36</i>
	 */
	native public boolean nextFrame();

	/**
	 * Original signature : <code>int getWidth()</code><br>
	 * <i>native declaration : line 37</i>
	 */
	native public int getWidth();

	/**
	 * Original signature : <code>int getHeight()</code><br>
	 * <i>native declaration : line 38</i>
	 */
	native public int getHeight();

	/**
	 * Original signature : <code>char* getImage()</code><br>
	 * <i>native declaration : line 39</i>
	 */
	native public Pointer<Byte> getImage();

	public OpenIMAJCapGStreamer(Pointer pointer) {
		super(pointer);
	}

	/**
	 * Original signature : <code>int getBands()</code>
	 */
	public native int getBands();
}
