// Vertikleys
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

function isTooth(c) {
    return c !== ' ';
}

function readKeys() {
    var keyList = [ ];
    var tokens = stdin.readLine().replace(/\n/,'').split(' ');
    var numKeys = parseInt(tokens[0]);
    var keyLength = parseInt(tokens[1]);
    var labelLine = stdin.readLine().replace(/\n/,'');
    for( var i=0; i<labelLine.length; ++i ) {
        var c = labelLine.charAt(i);
        if( c !== ' ' ) {
            keyList.push({ label: c, column: i, leftTeeth: [], rightTeeth: [] });
        }
    }
    if( keyList.length !== numKeys+2 ) {
        stdout.writeLine("ERROR: wrong number of keys");
        syste.exit(1);
    }
    for( var i=0; i<keyLength; ++i ) {
        var dataLine = stdin.readLine().replace(/\n/,'');
        for( var n=0; n<keyList.length; ++n ) {
            var key = keyList[n];
            key.leftTeeth.push(isTooth(dataLine[key.column-1]));
            key.rightTeeth.push(isTooth(dataLine[key.column+1]));
        }
    }
    return keyList;
}

function cdr( list ) {
    var cdr = [ ];
    for( var i=1; i<list.length; ++i ) {
        cdr.push( list[i] );
    }
    return cdr;
}

function isMatched( keyLeft, keyRight ) {
    var result = true;
    for( var i=0; i<keyLeft.rightTeeth.length && result; ++i ) {
        result = ( keyLeft.rightTeeth[i] !== keyRight.leftTeeth[i] );
    }
    return result;
}

function spinKey( key ) {
    var tempTeeth = key.leftTeeth;
    key.leftTeeth = key.rightTeeth;
    key.rightTeeth = tempTeeth;
}

function flipKey( key ) {
    key.rightTeeth.reverse();
    key.leftTeeth.reverse();
}

function rotate(keys) {
    var temp = keys[0];
    var lastIndex = keys.length-2; // don't rotate the last item (dock)
    for( var i=1; i<=lastIndex; ++i ) {
        keys[i-1] = keys[i];
    }
    keys[lastIndex] = temp;
}

function findSolution( keys ) {
    if( keys.length === 2 ) {
        if( isMatched( keys[0], keys[1] ) ) {
            return keys;
        }
        else {
            return false;
        }
    }
    var cdrKeys = cdr(keys);
    for( var i=0; i<cdrKeys.length-1; ++i ) {
        for( var spin=0; spin<2; ++spin ) {

            spinKey( cdrKeys[0] );
            for( var flip=0; flip<2; ++flip ) {
                flipKey( cdrKeys[0] );
                if( isMatched( keys[0], cdrKeys[0] ) ) {
                    var solution = findSolution( cdrKeys );
                    if( solution ) {
                        solution.unshift(keys[0]);
                        return solution;
                    }
                }
            }
        }
        rotate(cdrKeys);
    }
    return false;
}

function printKeys( keys ) {
    var keyLength = keys[0].leftTeeth.length;
    var lastColumn = 1 + 5*(keys.length-1);
    var nextColumn = 1;
    var nextIndex = 0;
    var line = '';
    // print the column headings
    for( var n=0; n<=lastColumn; ++n ) {
        if( n === nextColumn ) {
            line += keys[nextIndex++].label;
            nextColumn += 5;
        }
        else {
            line += ' ';
        }
    }
    stdout.writeLine(line);

    for( var i=0; i<keyLength; ++i ) {
        line = '';
        nextColumn = 1;
        nextIndex = 0;
        for( var n=0; n<=lastColumn+1; ++n ) {
            if( n === nextColumn-1 ) {
                line += keys[nextIndex].leftTeeth[i] ? ( nextIndex === 0 ? "[" : "<" ) : " ";
            }
            else if( n === nextColumn ) {
                line += '|';
            }
            else if( n === nextColumn+1 ) {
                // line += "#";
                line += keys[nextIndex].rightTeeth[i] ? ( ( nextIndex === keys.length-1 ) ? "]" : ">" ) : " ";
                nextColumn += 5;
                ++nextIndex;
            }
            else {
                line += ' ';
            }
        }
        stdout.writeLine(line);
    }
}

function main() {
    var keys = readKeys();
    // printKeys( keys );
    var solution = findSolution( keys );
    printKeys( solution );
}

main();
