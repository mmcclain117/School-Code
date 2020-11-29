#!/usr/bin/env python
# Author: Sebastian.Schagerer@hpe.com

import sys
import math

(readings, num_test_values) = sys.stdin.readline().split(" ")

calibration_readings = []

for r in range(0, int(readings.strip())):
    (s, v) = sys.stdin.readline().split(" ")
    # print "dist=%d sensor=%d" % (int(distance), int(sensor_value))
    calibration_readings.append((s, v))

k_values = []
for (s, v) in calibration_readings:
    for (s1, v1) in calibration_readings:
        if int(v1) == int(v):
            continue
        if int(v) < int(v1):
            v_near = int(v)
            v_far = int(v1)
            s_near = int(s)
            s_far = int(s1)
        else:
            v_near = int(v1)
            v_far = int(v)
            s_near = int(s1)
            s_far = int(s)

        # print "near (%d, %d) far (%d, %d)" % (neard, nears, fard, fars)
        k = (s_far - s_near) / ((1 / math.sqrt(v_far)) - (1 / math.sqrt(v_near)))
        k_values.append(k)
        # print k

# print k_values

k_sum = 0.0
for k in k_values:
    k_sum += k

k_final = k_sum / len(k_values)

print "k = %f" % k_final

e_values = []
for (s, v) in calibration_readings:
    e = (k_final / math.sqrt(int(v))) - int(s)
    e_values.append(e)

# print e_values

e_sum = 0.0
for e in e_values:
    e_sum += e

e_final = e_sum / len(e_values)

print "e = %f" % e_final

test_values = sys.stdin.readline().split(" ")

# print test_values

for t_value in test_values:
    dist = k_final / math.sqrt(int(t_value)) - e_final
    print t_value, dist
