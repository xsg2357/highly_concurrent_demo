package com.example.highly_concurrent_demo.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class CountDownLatchExample {

    private static final int  threadCount = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            final  int threadNum = i;
            executorService.execute(()->{
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                    log.error("parse:{}",e.getMessage());
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        log.error("finish");
        executorService.shutdown();
//        09:51:17.338 [pool-1-thread-75] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 74
//        09:51:17.338 [pool-1-thread-36] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 35
//        09:51:17.329 [pool-1-thread-6] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 5
//        09:51:17.338 [pool-1-thread-48] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 47
//        09:51:17.329 [pool-1-thread-11] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 10
//        09:51:17.338 [pool-1-thread-52] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 51
//        09:51:17.329 [pool-1-thread-14] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 13
//        09:51:17.329 [pool-1-thread-9] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 8
//        09:51:17.328 [pool-1-thread-15] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 14
//        09:51:17.338 [pool-1-thread-55] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 54
//        09:51:17.329 [pool-1-thread-12] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 11
//        09:51:17.354 [pool-1-thread-156] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 155
//        09:51:17.345 [pool-1-thread-102] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 101
//        09:51:17.363 [pool-1-thread-172] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 171
//        09:51:17.338 [pool-1-thread-37] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 36
//        09:51:17.354 [pool-1-thread-149] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 148
//        09:51:17.337 [pool-1-thread-71] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 70
//        09:51:17.329 [pool-1-thread-13] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 12
//        09:51:17.346 [pool-1-thread-94] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 93
//        09:51:17.338 [pool-1-thread-77] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 76
//        09:51:17.338 [pool-1-thread-39] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 38
//        09:51:17.363 [pool-1-thread-157] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 156
//        09:51:17.363 [pool-1-thread-193] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 192
//        09:51:17.363 [pool-1-thread-170] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 169
//        09:51:17.354 [pool-1-thread-155] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 154
//        09:51:17.355 [pool-1-thread-161] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 160
//        09:51:17.363 [pool-1-thread-190] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 189
//        09:51:17.354 [pool-1-thread-144] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 143
//        09:51:17.354 [pool-1-thread-153] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 152
//        09:51:17.337 [pool-1-thread-70] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 69
//        09:51:17.363 [pool-1-thread-183] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 182
//        09:51:17.338 [pool-1-thread-45] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 44
//        09:51:17.329 [pool-1-thread-24] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 23
//        09:51:17.363 [pool-1-thread-194] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 193
//        09:51:17.345 [pool-1-thread-104] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 103
//        09:51:17.345 [pool-1-thread-96] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 95
//        09:51:17.338 [pool-1-thread-56] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 55
//        09:51:17.369 [pool-1-thread-165] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 164
//        09:51:17.346 [pool-1-thread-117] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 116
//        09:51:17.355 [pool-1-thread-158] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 157
//        09:51:17.345 [pool-1-thread-98] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 97
//        09:51:17.363 [pool-1-thread-184] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 183
//        09:51:17.328 [pool-1-thread-17] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 16
//        09:51:17.329 [pool-1-thread-35] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 34
//        09:51:17.355 [pool-1-thread-129] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 128
//        09:51:17.329 [pool-1-thread-32] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 31
//        09:51:17.363 [pool-1-thread-187] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 186
//        09:51:17.355 [pool-1-thread-160] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 159
//        09:51:17.328 [pool-1-thread-29] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 28
//        09:51:17.354 [pool-1-thread-141] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 140
//        09:51:17.369 [pool-1-thread-163] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 162
//        09:51:17.363 [pool-1-thread-188] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 187
//        09:51:17.338 [pool-1-thread-76] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 75
//        09:51:17.346 [pool-1-thread-87] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 86
//        09:51:17.355 [pool-1-thread-131] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 130
//        09:51:17.354 [pool-1-thread-142] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 141
//        09:51:17.354 [pool-1-thread-146] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 145
//        09:51:17.355 [pool-1-thread-130] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 129
//        09:51:17.338 [pool-1-thread-58] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 57
//        09:51:17.355 [pool-1-thread-132] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 131
//        09:51:17.347 [pool-1-thread-122] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 121
//        09:51:17.363 [pool-1-thread-180] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 179
//        09:51:17.345 [pool-1-thread-103] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 102
//        09:51:17.354 [pool-1-thread-143] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 142
//        09:51:17.345 [pool-1-thread-110] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 109
//        09:51:17.328 [pool-1-thread-1] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 0
//        09:51:17.338 [pool-1-thread-69] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 68
//        09:51:17.345 [pool-1-thread-108] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 107
//        09:51:17.354 [pool-1-thread-140] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 139
//        09:51:17.345 [pool-1-thread-99] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 98
//        09:51:17.338 [pool-1-thread-53] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 52
//        09:51:17.345 [pool-1-thread-83] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 82
//        09:51:17.338 [pool-1-thread-73] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 72
//        09:51:17.348 [pool-1-thread-126] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 125
//        09:51:17.354 [pool-1-thread-147] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 146
//        09:51:17.345 [pool-1-thread-105] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 104
//        09:51:17.345 [pool-1-thread-23] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 22
//        09:51:17.345 [pool-1-thread-97] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 96
//        09:51:17.345 [pool-1-thread-109] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 108
//        09:51:17.346 [pool-1-thread-116] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 115
//        09:51:17.345 [pool-1-thread-93] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 92
//        09:51:17.348 [pool-1-thread-127] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 126
//        09:51:17.363 [pool-1-thread-192] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 191
//        09:51:17.338 [pool-1-thread-44] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 43
//        09:51:17.345 [pool-1-thread-95] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 94
//        09:51:17.346 [pool-1-thread-81] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 80
//        09:51:17.355 [pool-1-thread-128] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 127
//        09:51:17.345 [pool-1-thread-107] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 106
//        09:51:17.338 [pool-1-thread-65] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 64
//        09:51:17.346 [pool-1-thread-90] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 89
//        09:51:17.348 [pool-1-thread-125] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 124
//        09:51:17.345 [pool-1-thread-113] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 112
//        09:51:17.354 [pool-1-thread-133] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 132
//        09:51:17.338 [pool-1-thread-38] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 37
//        09:51:17.338 [pool-1-thread-61] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 60
//        09:51:17.338 [pool-1-thread-63] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 62
//        09:51:17.339 [pool-1-thread-20] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 19
//        09:51:17.370 [pool-1-thread-164] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 163
//        09:51:17.339 [pool-1-thread-3] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 2
//        09:51:17.363 [pool-1-thread-200] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 199
//        09:51:17.346 [pool-1-thread-82] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 81
//        09:51:17.338 [pool-1-thread-2] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 1
//        09:51:17.363 [pool-1-thread-197] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 196
//        09:51:17.328 [pool-1-thread-25] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 24
//        09:51:17.345 [pool-1-thread-111] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 110
//        09:51:17.345 [pool-1-thread-91] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 90
//        09:51:17.338 [pool-1-thread-22] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 21
//        09:51:17.363 [pool-1-thread-196] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 195
//        09:51:17.345 [pool-1-thread-114] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 113
//        09:51:17.369 [pool-1-thread-166] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 165
//        09:51:17.347 [pool-1-thread-123] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 122
//        09:51:17.346 [pool-1-thread-115] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 114
//        09:51:17.329 [pool-1-thread-8] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 7
//        09:51:17.363 [pool-1-thread-159] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 158
//        09:51:17.346 [pool-1-thread-88] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 87
//        09:51:17.369 [pool-1-thread-167] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 166
//        09:51:17.346 [pool-1-thread-119] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 118
//        09:51:17.345 [pool-1-thread-112] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 111
//        09:51:17.363 [pool-1-thread-168] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 167
//        09:51:17.363 [pool-1-thread-198] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 197
//        09:51:17.363 [pool-1-thread-171] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 170
//        09:51:17.338 [pool-1-thread-79] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 78
//        09:51:17.338 [pool-1-thread-59] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 58
//        09:51:17.338 [pool-1-thread-68] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 67
//        09:51:17.345 [pool-1-thread-100] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 99
//        09:51:17.328 [pool-1-thread-27] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 26
//        09:51:17.328 [pool-1-thread-30] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 29
//        09:51:17.355 [pool-1-thread-162] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 161
//        09:51:17.346 [pool-1-thread-85] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 84
//        09:51:17.363 [pool-1-thread-199] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 198
//        09:51:17.347 [pool-1-thread-121] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 120
//        09:51:17.346 [pool-1-thread-86] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 85
//        09:51:17.338 [pool-1-thread-49] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 48
//        09:51:17.354 [pool-1-thread-134] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 133
//        09:51:17.354 [pool-1-thread-137] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 136
//        09:51:17.345 [pool-1-thread-92] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 91
//        09:51:17.329 [pool-1-thread-10] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 9
//        09:51:17.329 [pool-1-thread-18] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 17
//        09:51:17.346 [pool-1-thread-118] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 117
//        09:51:17.347 [pool-1-thread-124] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 123
//        09:51:17.338 [pool-1-thread-62] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 61
//        09:51:17.338 [pool-1-thread-50] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 49
//        09:51:17.339 [pool-1-thread-21] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 20
//        09:51:17.346 [pool-1-thread-89] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 88
//        09:51:17.354 [pool-1-thread-135] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 134
//        09:51:17.354 [pool-1-thread-139] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 138
//        09:51:17.363 [pool-1-thread-191] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 190
//        09:51:17.328 [pool-1-thread-26] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 25
//        09:51:17.329 [pool-1-thread-5] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 4
//        09:51:17.329 [pool-1-thread-31] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 30
//        09:51:17.329 [pool-1-thread-34] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 33
//        09:51:17.354 [pool-1-thread-136] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 135
//        09:51:17.338 [pool-1-thread-54] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 53
//        09:51:17.354 [pool-1-thread-154] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 153
//        09:51:17.328 [pool-1-thread-28] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 27
//        09:51:17.345 [pool-1-thread-101] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 100
//        09:51:17.338 [pool-1-thread-80] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 79
//        09:51:17.338 [pool-1-thread-42] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 41
//        09:51:17.345 [pool-1-thread-106] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 105
//        09:51:17.339 [pool-1-thread-84] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 83
//        09:51:17.329 [pool-1-thread-4] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 3
//        09:51:17.363 [pool-1-thread-186] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 185
//        09:51:17.338 [pool-1-thread-64] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 63
//        09:51:17.363 [pool-1-thread-181] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 180
//        09:51:17.354 [pool-1-thread-138] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 137
//        09:51:17.363 [pool-1-thread-182] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 181
//        09:51:17.347 [pool-1-thread-120] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 119
//        09:51:17.338 [pool-1-thread-51] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 50
//        09:51:17.338 [pool-1-thread-78] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 77
//        09:51:17.338 [pool-1-thread-67] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 66
//        09:51:17.337 [pool-1-thread-33] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 32
//        09:51:17.338 [pool-1-thread-66] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 65
//        09:51:17.354 [pool-1-thread-145] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 144
//        09:51:17.363 [pool-1-thread-195] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 194
//        09:51:17.354 [pool-1-thread-148] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 147
//        09:51:17.363 [pool-1-thread-173] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 172
//        09:51:17.338 [pool-1-thread-60] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 59
//        09:51:17.363 [pool-1-thread-169] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 168
//        09:51:17.328 [pool-1-thread-19] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 18
//        09:51:17.338 [pool-1-thread-40] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 39
//        09:51:17.329 [pool-1-thread-7] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 6
//        09:51:17.338 [pool-1-thread-57] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 56
//        09:51:17.354 [pool-1-thread-152] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 151
//        09:51:17.338 [pool-1-thread-46] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 45
//        09:51:17.363 [pool-1-thread-179] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 178
//        09:51:17.363 [pool-1-thread-176] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 175
//        09:51:17.338 [pool-1-thread-41] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 40
//        09:51:17.363 [pool-1-thread-174] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 173
//        09:51:17.363 [pool-1-thread-178] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 177
//        09:51:17.363 [pool-1-thread-175] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 174
//        09:51:17.354 [pool-1-thread-151] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 150
//        09:51:17.329 [pool-1-thread-16] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 15
//        09:51:17.363 [pool-1-thread-177] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 176
//        09:51:17.338 [pool-1-thread-43] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 42
//        09:51:17.337 [pool-1-thread-74] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 73
//        09:51:17.363 [pool-1-thread-189] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 188
//        09:51:17.338 [pool-1-thread-72] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 71
//        09:51:17.354 [pool-1-thread-150] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 149
//        09:51:17.363 [pool-1-thread-185] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 184
//        09:51:17.338 [pool-1-thread-47] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - 46
//        09:51:17.521 [main] ERROR com.example.highly_concurrent_demo.aqs.CountDownLatchExample - finish
    }


    private static void test(int  threadNum) throws InterruptedException {
        Thread.sleep(100);
        log.error("{}",threadNum);
        Thread.sleep(100);
    }
}
