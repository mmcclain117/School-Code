#!/usr/bin/env python3


import fileinput
import math


def estimate_k(snear, vnear, sfar, vfar):
    return (sfar - snear) / (1.0 / math.sqrt(vfar) - 1.0 / math.sqrt(vnear))


def estimate_e(k, s, v):
    return k / math.sqrt(v) - s


def calibrate(cals):
    ks = []

    for (s1, v1) in cals:
        for (s2, v2) in cals:
            if s2 <= s1:
                continue
            ks.append(estimate_k(s1, v1, s2, v2))

    k = (sum(ks) / len(ks))

    es = []

    for (s1, v1) in cals:
        es.append(estimate_e(k, s1, v1))

    e = (sum(es) / len(es))

    return k, e


def evaluate(k, e, v):
    return k / math.sqrt(v) - e


calcount = None
testcount = None
i = 0
cals = []
for line in fileinput.input():
    if calcount is None:
        (calcount, testcount) = list(map(int, line.split()))
        continue

    if i == calcount:
        (k, e) = calibrate(cals)
        print("k = {}".format(k))
        print("e = {}".format(e))
        for v in list(map(int, line.split())):
            print(v, evaluate(k, e, v))
        break

    cals.append(list(map(int, line.split())))
    i += 1
