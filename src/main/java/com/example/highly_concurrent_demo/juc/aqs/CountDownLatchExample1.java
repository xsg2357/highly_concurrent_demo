package com.example.highly_concurrent_demo.juc.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CountDownLatchExample1 {

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
        countDownLatch.await(10, TimeUnit.MILLISECONDS);
        log.error("finish");
        executorService.shutdown();//这里是等线程池把所有的线程执行完 在关闭掉线程池

//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 15
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 14
//        om.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 0
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 12
//        om.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 4
//        om.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 2
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 13
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 11
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 10
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 16
//        om.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 7
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 23
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 20
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 17
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 21
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 22
//        om.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 8
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 31
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 24
//        om.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 6
//        om.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 3
//        om.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 1
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 9
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 32
//        om.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 5
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 18
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 27
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 28
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 25
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 26
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 19
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 29
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 39
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 47
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 68
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 48
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 51
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 56
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 64
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 63
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 33
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 34
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 30
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 71
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 67
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 72
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 53
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 38
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 37
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 42
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 44
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 35
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 43
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 40
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 45
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 41
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 46
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 49
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 52
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 73
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 55
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 50
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 58
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 80
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 87
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 79
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 75
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 54
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 62
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 57
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 36
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 59
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 66
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 65
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 60
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 61
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 76
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 84
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 83
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 95
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 92
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 88
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 99
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 144
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 147
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 91
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 149
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 137
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 100
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 139
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 150
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 140
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 141
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 155
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 142
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 132
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 143
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 138
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 130
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 146
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 136
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 135
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 152
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 157
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 70
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 156
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 151
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 133
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 126
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 145
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 154
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 153
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 128
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 148
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 119
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 134
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 129
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 127
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 131
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 123
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 114
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 109
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 115
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 106
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 117
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 105
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 121
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 101
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 89
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 122
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 90
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 118
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 93
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 110
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 112
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 102
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 94
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 82
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 191
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 113
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 78
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 69
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 111
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 181
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 97
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 98
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 96
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 85
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 177
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 81
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 192
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 86
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 176
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 178
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 173
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 74
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 77
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 107
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 116
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 103
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 125
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 194
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 165
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 164
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 104
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 108
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 124
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 158
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 175
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 174
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 189
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 120
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 172
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 182
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 197
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 162
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 198
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 180
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 183
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 184
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 187
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 188
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 195
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 196
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 171
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 199
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 179
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 161
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 185
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 170
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 169
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 166
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 163
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 160
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 190
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 168
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 186
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 193
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 167
//        com.example.highly_concurrent_demo.aqs.CountDownLatchExample1 - 159

    }


    private static void test(int  threadNum) throws InterruptedException {
        Thread.sleep(100);
        log.error("{}",threadNum);
//        Thread.sleep(100);
    }
}
