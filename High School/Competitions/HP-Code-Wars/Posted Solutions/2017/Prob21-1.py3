import sys

def IsPerfect (def_word, substrings):
    for end in range(2, len(def_word) + 1):
        if def_word[:end] in substrings:
            if end == len(def_word):
                return True
            else:
                if IsPerfect (def_word[end : len(def_word)], substrings):
                    return True
    return False


num = int(sys.stdin.readline().strip())
for _ in range(num):
    entry = sys.stdin.readline().strip().split('-')
    def_word = entry[0].strip()
    definition = entry[1].split()

    #Eliminate cases where there are letters in the word to be defined that don't exist in the definition.
    if any(map(lambda x : not x in entry[1], [l for l in def_word])):
        print('Imperfect!')
        continue

    substrings = set([word[start:end] for word in definition for start in range(0, len(word)) for end in range(start + 2, len(word) + 1) if word[start:end] in def_word])

    if IsPerfect(def_word, substrings):
        print('Perfect')
    else:
        print('Imperfect!')

