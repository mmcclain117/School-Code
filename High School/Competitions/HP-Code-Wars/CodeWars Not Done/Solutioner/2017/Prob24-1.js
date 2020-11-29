// Hexagon Puzzle
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

var system = require("system");
var stdin = require("system").stdin;
var stdout = require("system").stdout;

function readHexagons() {
    var hexagons = [ ];
    for( var i=0; i<7; i++ ) {
        var tokens = stdin.readLine().replace(/\n/,'').split(' ');
        hexagons.push(tokens);
    }
    return hexagons;
}

// edge indexing:
//     4   5
//      \ / 
//   3---*---0
//      / \   
//     2   1  
//
// hexagon position indexing:
//       x   x   x   x
//        \ /     \ /
//     x---0--0?3--1---x
//       2/ \1   2/ \1
//   x   ?   ?   ?   ?   x
//    \5/    4\ /5   4\ /
// x---2--0?3--3--0?3--4---x
//    / \1   2/ \1   2/ \
//   x   ?   ?   ?   ?   x
//       4\ /5   4\ /5
//     x---5--0?3--6---x
//        / \     / \
//       x   x   x   x
//
// a single permutation looks like this:
//  [ { hexIndex: 0, offset: 0 }, { hexIndex: 1, offset: 0 }, ..., { hexIndex: 5, offset: 0 } ]
//
// a single hexagon looks like this:
//  [ "A", "V", "R", "M", "G", "Q" ]
var edgeMeets = [
    [ { position: 0, edge: 0 }, { position: 1, edge: 3 } ],
    [ { position: 0, edge: 2 }, { position: 2, edge: 5 } ],
    [ { position: 0, edge: 1 }, { position: 3, edge: 4 } ],
    [ { position: 1, edge: 2 }, { position: 3, edge: 5 } ],
    [ { position: 1, edge: 1 }, { position: 4, edge: 4 } ],
    [ { position: 2, edge: 0 }, { position: 3, edge: 3 } ],
    [ { position: 3, edge: 0 }, { position: 4, edge: 3 } ],
    [ { position: 2, edge: 1 }, { position: 5, edge: 4 } ],
    [ { position: 3, edge: 2 }, { position: 5, edge: 5 } ],
    [ { position: 3, edge: 1 }, { position: 6, edge: 4 } ],
    [ { position: 4, edge: 2 }, { position: 6, edge: 5 } ],
    [ { position: 5, edge: 0 }, { position: 6, edge: 3 } ]
];

function isItemInArray( a, n ) {
    for( var i=0; i<a.length; ++i ) {
        if( a[i] === n )
            return true;
    }
    return false;
}

// map the center hexagon's edge to the index of the adjoining hexagon
var edgeHexMap = [ 4, 6, 5, 2, 0, 1 ];
function isPossibleSolution( hexagons, permutation ) {
    var isPossible = true;
    var centerHexagon = hexagons[ permutation[3] ];
    // console.log("centerHexagon is "+centerHexagon);
    for( var offset=0; offset<6; ++offset ) {
        isPossible = true;
        // console.log("### offset = "+offset);
        for( var e=0; e<centerHexagon.length && isPossible; e++ ) {
            var edgeLetter = centerHexagon[(e+offset)%6];
            // console.log("  - edgeLetter "+e+" is "+edgeLetter);
            var otherHexagon = hexagons[ permutation[ edgeHexMap[e] ] ];
            // console.log("    otherHexagon "+edgeHexMap[e]+" is "+otherHexagon);
            isPossible = isItemInArray( otherHexagon, edgeLetter );
        }
        if( isPossible )
            break;
    }
    return isPossible;
}

function testIsPossible( hexagons ) {
    var permutation = [ 4, 1, 2, 6, 5, 0, 3 ];
    var permutation = [ 2, 4, 0, 6, 1, 3, 5 ];
    if( isPossibleSolution( hexagons, permutation ) ) {
        console.log("testIsPossible PASSED");
    }
    else {
        console.log("testIsPossible FAILED");
    }
}

function isSolution( hexagons, permutation, offsets ) {
    var isValid = true;
    // console.log("### checking permutation "+permutation);
    for( var i=0; i<edgeMeets.length && isValid; ++i ) {
        var m1 = edgeMeets[i][0];
        var m2 = edgeMeets[i][1];
        var h1 = hexagons[ permutation[ m1.position ] ]; //  [ "A", "V", "R", "M", "G", "Q" ]
        var h2 = hexagons[ permutation[ m2.position ] ]; //  [ "M", "B", "G", "L", "W", "P" ]
        // console.log("compare position "+m1.position+" edge "+m1.edge+" of hexagon "+h1);
        // console.log("   with position "+m2.position+" edge "+m2.edge+" of hexagon "+h2);
        var o1 = offsets[ m1.position ];
        var o2 = offsets[ m2.position ];
        var e1 = h1[ ( m1.edge + o1 ) % 6 ];
        var e2 = h2[ ( m2.edge + o2 ) % 6 ];
        isValid = ( e1 === e2 );
    }
    return isValid;
}

function incrementOffsets( offsets ) {
    var isOverflow = true;
    var radix = 0;
    while( isOverflow && radix < offsets.length ) {
        if( ++offsets[radix] === 6 ) {
            // overflow; set to zero and continue overflow
            offsets[radix++] = 0;
        }
        else {
            isOverflow = false;
        }
    }
    return isOverflow;
}

function testOffsets() {
    var offsets = [ 0, 0, 0 ];
    var isOverflow = false;
    while( !isOverflow ) {
        // console.log( "testOffsets: " + offsets[0] + offsets[1] + offsets[2] );
        isOverflow = incrementOffsets( offsets );
    }
}

function checkSolutions( hexagons, permutations ) {
    for( var p=0; p<permutations.length; ++p ) {
        if( isPossibleSolution( hexagons, permutations[p] ) ) {
            // console.log("checking "+p);
            var offsets = [ 0, 0, 0, 0, 0, 0, 0 ];
            // var offsets = [ 5, 0, 4, 5, 3, 2, 1 ]; // USE THIS FOR UNIT TESTING:
            var isOverflow = false;
            var pNumber = 0;
            while( !isOverflow ) {
                // console.log( "### checking offset number "+ (pNumber++) + ": " + offsets );
                if( isSolution( hexagons, permutations[p], offsets ) ) {
                    // console.log("________ [ SOLUTION ] ________");
                    var line = "";
                    for( var i=0; i<7; ++i ) {
                        var h = hexagons[ permutations[p][i] ];
                        line += permutations[p][i] + " " + h[ offsets[i] ] + " ";
                    }
                    stdout.writeLine(line);
                }
                isOverflow = incrementOffsets( offsets );
            }
        }
    }
}

function testSolutionCheck( hexagons ) {
    var permutations = [ [ 4, 1, 2, 6, 5, 0, 3 ] ];
    checkSolutions( hexagons, permutations );
}

function getPermutations( items ) {
    var list = [ ];
    if( items.length === 1 ) {
        list.push( [ items[0] ] );
    }
    else {
        for( var i=0; i<items.length; i++ ) {
            var subItems = [ ];
            for( var j=0; j<items.length; j++ ) {
                if( i !== j )
                    subItems.push( items[j] );
            }
            var subList = getPermutations( subItems );
            for( var s=0; s<subList.length; s++ )
                subList[s].push( items[i] );
            list = list.concat( subList );
        }
    }
    return list;
};

function main() {
    var hexagons = readHexagons();
    // var hexagons = [ // these are for the unit tests
    //     [ "W", "T", "J", "G", "N", "D" ],
    //     [ "X", "F", "W", "K", "C", "M" ],
    //     [ "M", "N", "X", "T", "R", "W" ],
    //     [ "B", "C", "V", "Q", "J", "G" ],
    //     [ "M", "T", "S", "D", "V", "K" ],
    //     [ "C", "F", "S", "G", "K", "B" ],
    //     [ "G", "T", "R", "M", "W", "C" ]
    // ];
    // testOffsets();
    // testIsPossible( hexagons );
    // testSolutionCheck( hexagons );
    var permutations = getPermutations( [ 0, 1, 2, 3, 4, 5, 6 ] );
    checkSolutions( hexagons, permutations );
}

main();
