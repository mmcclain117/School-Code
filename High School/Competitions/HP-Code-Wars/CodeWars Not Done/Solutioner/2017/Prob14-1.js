let stdin = require('system').stdin;
let stdout = require('system').stdout;

(function tutors() {
    let size = stdin.readLine().trim().split(/\s/).map(Number),
        x = size[0],
        y = size[1];

    while (x && y) {
        let grid = [];

        for (let row = 0; row < x; row++) {
            grid.push(stdin.readLine().trim());
        }

        stdout.writeLine(solve(grid));

        size = stdin.readLine().trim().split(/\s/).map(Number);
        x = size[0];
        y = size[1];
    }

    function solve(grid) {
        let res = Array.apply(0, Array(x)).map(function() { return Array.apply(0, Array(y)); });

        for (let xx = 0; xx < x; xx++) {
            for (let yy = 0; yy < y; yy++) {
                if (xx === 0 && yy === 0) {
                    // Start square. If square has no ore, number of ways is one.
                    res[xx][yy] = grid[xx][yy] === '.' ? 1 : 0;
                }
                else if (xx === 0) {
                    // Top row. If square has no ore, number of ways is same as square to left.
                    res[xx][yy] = grid[xx][yy] === '.' ? res[xx][yy-1] : 0;
                }
                else if (yy === 0) {
                    // Left column. If square has no ore, number of ways is same as square above.
                    res[xx][yy] = grid[xx][yy] === '.' ? res[xx-1][yy] : 0;
                }
                else {
                    // Rest of grid. If square has no ore, number of ways to reach current square equals
                    // number of ways to reach square above + number of ways to reach square to left.
                    res[xx][yy] = grid[xx][yy] === '.' ? res[xx-1][yy] + res[xx][yy-1] : 0;
                }
            }
        }

        return res[x-1][y-1];
    }
})();