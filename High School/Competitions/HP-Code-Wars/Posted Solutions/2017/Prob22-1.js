// Dragon Fractal
// Code Wars program written in JavaScript for the RingoJS environment
//
// The MIT License (MIT)
//
// Copyright (c) 2016 Lee Jenkins
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

function normalize( direction ) {
    if( direction < 1 ) {
        direction += 8;
    }
    if( direction > 8 ) {
        direction -= 8;
    }
    return direction;
}

function printCurve( curve ) {
    var text = "### CURVE: ";
    for( var i=0; i<curve.length; i++ ) {
        text += " " + curve[i];
    }
    console.log( text );
}

function generateCurve( direction, iterations ) {
    // console.log( "function generateCurve; direction="+direction+", iterations="+iterations );
    var curve = [ direction, normalize(direction-2) ];
    // printCurve( curve );
    // r-substitution:   N -> N+1, N-1
    // l-substitution:   N -> N-1, N+1
    var delta = 1; // add 1 to direction for a right turn, subtract 1 for left
    for( var i=0; i<iterations; ++i ) {
        var newCurve = [ ];
        for( var j=0; j<curve.length; ++j ) {
            // console.log("   replace " + curve[j] + " with " + normalize( curve[j] + delta )+ ", " + normalize( curve[j] - delta )  );
            newCurve.push( normalize( curve[j] + delta ) );
            newCurve.push( normalize( curve[j] - delta ) );
            delta = -1 * delta;
        }
        curve = newCurve;
        // printCurve( curve );
    }
    return curve;
}

function initializeGrid( GRID_SIZE ) {
    // console.log( "function initializeGrid; GRID_SIZE="+GRID_SIZE );
    var grid = [ ];
    for( var y=0; y<GRID_SIZE; ++y ) {
        var row = [ ];
        for( var x=0; x<GRID_SIZE; ++x ) {
            row.push("  ");
        }
        // all these array.push calls are slow,
        // but they are easy to read
        grid.push(row);
    }
    return grid;
}

// x-axis points to the right
// y-axis points **down**
var vectors = [
    { dx:  0,  dy:  0 }, // 0 (NOT USED)
    { dx:  1,  dy: -1 }, // 1
    { dx:  1,  dy:  0 }, // 2 right
    { dx:  1,  dy:  1 }, // 3
    { dx:  0,  dy:  1 }, // 4 down
    { dx: -1,  dy:  1 }, // 5
    { dx: -1,  dy:  0 }, // 6 left
    { dx: -1,  dy: -1 }, // 7
    { dx:  0,  dy: -1 }, // 8 up
];

function drawCurve( curve ) {
    var GRID_SIZE = 1024;
    var grid = initializeGrid( GRID_SIZE );
    var xMin = GRID_SIZE;
    var xMax = 0;
    var yMin = GRID_SIZE;
    var yMax = 0;
    var x = GRID_SIZE / 2;
    var y = GRID_SIZE / 2;

    // console.log( "function drawCurve; curve.length="+curve.length );

    for( var i=0; i<curve.length; ++i ) {
        var v = vectors[ curve[i] ];
        for( var j=0; j<3; ++j ) {
            var gx = x + j * v.dx;
            var gy = y + j * v.dy;
            grid[ gx ][ gy ] = "# ";
            if( xMax < gx ) xMax = gx;
            if( xMin > gx ) xMin = gx;
            if( yMax < gy ) yMax = gy;
            if( yMin > gy ) yMin = gy;
        }
        x += 2 * v.dx;
        y += 2 * v.dy;
    }
    // console.log( "function drawCurve; xMin="+xMin );
    // console.log( "function drawCurve; xMax="+xMax );
    // console.log( "function drawCurve; x-width="+ (xMax-xMin) );
    // console.log( "function drawCurve; yMin="+yMin );
    // console.log( "function drawCurve; yMax="+yMax );
    // now print the cropped grid
    for( y=yMin; y<=yMax; ++y ) {
        var line = ""
        for( x=xMin; x<=xMax; ++x ) {
            line += grid[x][y];
        }
        stdout.writeLine(line);
    }
}

function main() {
    var tokens = stdin.readLine().replace(/\n/,'').split(' ');
    var curve = generateCurve( parseInt(tokens[0]), parseInt(tokens[1]) );
    drawCurve( curve );
}

main();
