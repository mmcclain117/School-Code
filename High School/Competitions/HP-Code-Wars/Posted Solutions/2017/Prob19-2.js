// Robot Distance Sensor
// Code Wars program written in JavaScript for the RingoJS environment
//
// the problem description was originally written with the word "dice"
// instead of "cubes" and this program was written using dice naming.
//
// The MIT License (MIT)
//
// Copyright (c) 2017 Lee Jenkins
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.

var stdin = require("system").stdin;
var stdout = require("system").stdout;

function readOneLineOfTokens() {
    return stdin.readLine().replace(/\n/,'').trim().split(/ +/);
}

function main() {

    var tokens = readOneLineOfTokens();
    var numberOfCalibrations = tokens[0];
    var numberOfTestValues   = tokens[1];
    var calibrations = [ ];
    for( var i=0; i<numberOfCalibrations; ++i ) {
        tokens = readOneLineOfTokens();
        calibrations.push({
            distance: tokens[0],
            sensorValue: tokens[1]
        });
    }
    calibrations.sort( function(a,b) {
        return a.distance - b.distance;
    });
    // for( var i=0; i<calibrations.length; ++i ) {
    //     stdout.writeLine(calibrations[i].distance);
    // }
    var testValues = readOneLineOfTokens();

    var kSum = 0;
    for( var i=1; i<numberOfCalibrations; ++i ) {
        kSum += ( calibrations[i].distance - calibrations[i-1].distance ) /
                ( (1/Math.sqrt(calibrations[i].sensorValue)) - (1/Math.sqrt(calibrations[i-1].sensorValue))  );
    }
    var k = kSum / ( numberOfCalibrations - 1 );

    var eSum = 0;
    for( var i=0; i<numberOfCalibrations; ++i ) {
        var temp = ( k / Math.sqrt(calibrations[i].sensorValue)) - calibrations[i].distance;
        // stdout.writeLine( "v = " + calibrations[i].sensorValue );
        // stdout.writeLine( "s = " + calibrations[i].distance );
        // stdout.writeLine( "e = " + temp );
        eSum += ( k / Math.sqrt(calibrations[i].sensorValue)) - calibrations[i].distance;
    }
    var e = eSum / numberOfCalibrations;

    stdout.writeLine("k = "+k);
    stdout.writeLine("e = "+e);

    for( var i=0; i<testValues.length; ++i ) {
        var s = k / Math.sqrt(testValues[i] ) - e;
        stdout.writeLine( testValues[i] + " " + s );
    }

}

main();
