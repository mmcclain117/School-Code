// I, for One, Like Roman Numerals
// Code Wars program written in JavaScript for the RingoJS environment
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

function filter( s ) {
    return s.replace(/[^SIVXLCDM]/g,'');
}

function getValue( s0 ) {
    var previousLetter = "@";
    var S = "S";
    var I = "I";
    var V = "V";
    var X = "X";
    var L = "L";
    var C = "C";
    var D = "D";
    var M = "M";
    var values = { M: 1000, D: 500, C: 100, L: 50,  X: 10, V:5, I:1, S:0.5, "@": 987654321 };
    var validInversions = ".IV.IX.XL.XC.CD.CM.";
    var invalidRepeaters = "SVLD";
    var value = 0;
    var repeats = 0;
    for( var i=0; i<s0.length; ++i ) {
        var letter = s0[i];
        // console.log( letter + previousLetter + "   repeats="+repeats );
        if( values[letter] > values[previousLetter] ) {
            var pair = "." + previousLetter + letter + ".";
            if( validInversions.indexOf(pair) < 0 ) {
                value = 0; break; // invalid inversion
            }
            if( repeats ) {
                value = 0; break; // invalid: cannot subtract more than once
            }
            value += values[letter] - 2*values[previousLetter];
            // previousLetter = "@";
            repeats = 2; // do not allow repetition of subtracted letter
        }
        else {
            if( previousLetter === letter ) {
                if( ++repeats === 3 ) {
                    value = 0; break; // invalid: four of the same letter in a row
                }
                if( invalidRepeaters.indexOf(letter) >= 0 ) {
                    value = 0; break; // invalid: letter that cannot repeat
                }
            }
            else {
                repeats = 0;
            }
            value += values[letter];
            previousLetter = letter;
        }
    }
    return value;
}

function findLargestRomanNumeral( s ) {
    var largestValue = 0;
    var largestRomanNumeral = "";
    var PANIC = 0;
    for( var start=0; start < s.length; start++ ) {
        var candidate = "";
        var value = 0;
        while( start + candidate.length < s.length && ++PANIC < 99 ) {
            candidate += s.charAt(start+candidate.length);
            value = getValue( candidate );
            // console.log( "value of " + candidate + " is " + value );
            if( value === 0 ) {
                break;
            }
            if( value > largestValue ) {
                largestValue = value;
                largestRomanNumeral = candidate;
            }
        }
    }
    return largestRomanNumeral;
}

function printResult(num) {
    var value = getValue( num );
    if( value !== Math.floor(value) ) {
        value = Math.floor(value) + " 1/2";
    }
    stdout.writeLine( num + " " + value );
}

function main() {
    var text = stdin.readLine().trim();
    while( text !== '0' ) {
        text = filter( text.toUpperCase() );
        printResult( findLargestRomanNumeral(text) );
        text = stdin.readLine().trim();
    }
}

main();
