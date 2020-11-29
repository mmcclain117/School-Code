var stdin = require('system').stdin;
var stdout = require('system').stdout;

(function perfectlyDefined() {
    var tests = parseInt(stdin.readLine(), 10),
        line, word, definition;

    while (tests--) {
        line = stdin.readLine().split(/-/);
        word = line[0].trim();
        definition = line[1].trim();

        stdout.writeLine(can(word) ? 'Perfect' : 'Imperfect!');
    }

    function can(word) {
        // First two consecutive characters in word must be present in definition
        if (definition.indexOf(word.substr(0, 2)) === -1) {
            return false;
        }

        // Last two consecutive characters in word must be present in definition
        if (definition.indexOf(word.slice(-2)) === -1) {
            return false;
        }

        for (var i = 1, last = true, now; i+2 <= word.length; i++) {
            now = definition.indexOf(word.substr(i, 2)) !== -1;

            // If consecutive two-letter fragments from the word are missing
            // from the definition, the word is not perfectly defined
            if (!last && !now) {
                return false;
            }

            last = now;
        }

        return true;
    }
})();