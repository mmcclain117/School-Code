// PonyMon
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

var DEBUG = false;

function main() {
    var ponyData = readPonyData();
    var pairData = readPairData();
    simulateBattles( ponyData, pairData );
}

function simulateBattles( ponyData, pairData ) {
    for( var i=0; i<pairData.length; ++i ) {
        var pony = [ ponyData[ pairData[i][0] ], ponyData[ pairData[i][1] ] ];
        initializePonyForBattle( pony[0] );
        initializePonyForBattle( pony[1] );
        var p = 0;
        while( pony[p].hpRemaining > 0 ) {
            pony[p].powerCharges += 1;
            pony[1-p].hpRemaining -= attack( pony[p], pony[1-p] );
            p = 1 - p;
        }
        stdout.writeLine( pony[1-p].name + " defeats " + pony[p].name + " with " + pony[1-p].hpRemaining + " HP remaining."  );
    }
}

function attack( attacker, defender ) {
    var damage = 0;
    if( attacker.attack1power <= attacker.powerCharges ) {
        damage = attacker.attack1damage;
    }
    if( attacker.attack2power <= attacker.powerCharges ) {
        damage = Math.max( damage, attacker.attack2damage );
    }
    if( attacker.type === defender.weakness ) {
        if(DEBUG) stdout.writeLine( "   " + defender.name + " has a weakness to " + attacker.type );
        damage *= 2;
    }
    if( attacker.type === defender.resistance ) {
        if(DEBUG) stdout.writeLine( "   " + defender.name + " has a resistance to " + attacker.type );
        damage /= 2;
    }
    if( !damage ) {
        if(DEBUG) stdout.writeLine( "   " + attacker.name + " has " + attacker.powerCharges + " power and cannot attack." );
    }
    else {
        if(DEBUG) stdout.writeLine( "   " + attacker.name + " has " + attacker.powerCharges + " power and does " + damage + " points of damage to " + defender.name );
        if(DEBUG) stdout.writeLine( "   " + defender.name + " has " + (defender.hpRemaining-damage) + " HP remaining" );
    }
    return damage;
}

function initializePonyForBattle( pony ) {
    pony.hpRemaining = parseInt( pony.HP );
    pony.powerCharges = 0;
    pony.attack1power = parseInt( pony.attack1power );
    pony.attack1damage = parseInt( pony.attack1damage );
    pony.attack2power = parseInt( pony.attack2power );
    pony.attack2damage = parseInt( pony.attack2damage );
}

// 2
// Rhinopony Valkysiren
// Valkysiren TwilightPony
function readPairData() {
    var pairCount = parseInt( stdin.readLine() );
    var pairData = [ ];
    for( var i=0; i<pairCount; ++i ) {
        pairData.push( stdin.readLine().replace(/\n/,'').split(' ') );
    }
    return pairData;
}

// 3
// Rhinopony B L N 110 Trample 2 30 Skewer 4 90
// Valkysiren A M S 70 EnchantingSong 1 30 FlyBy 3 50
// TwilightPony P P X 80 Gallop 1 20  PlasmaBeam 4 80
function readPonyData() {
    var ponyCount = parseInt( stdin.readLine() );
    var propertyNames = [
        "name",
        "type",
        "weakness",
        "resistance",
        "HP",
        "attack1name",
        "attack1power",
        "attack1damage",
        "attack2name",
        "attack2power",
        "attack2damage"
    ];
    var ponyData = { };
    for( var i=0; i<ponyCount; ++i ) {
        var tokens = stdin.readLine().replace(/\n/,'').split(' ');
        var pony = { };
        for( var p=0; p<propertyNames.length; ++p ) {
            pony[propertyNames[p]] = tokens[p];
        }
        ponyData[pony.name] = pony;
    }
    return ponyData;
}

main();
