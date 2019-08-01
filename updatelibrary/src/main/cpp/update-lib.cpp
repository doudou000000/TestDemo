#include <jni.h>
#include <string>
#include<android/log.h>

extern "C" {
//bspatch.c中在执行合成方法就是其中main(int argc,char * argv[])
//所以在这里需要引入该方法
extern int bsPatch_main(int argc,char * argv[]);

extern int bsdiff_main(int argc,char * argv[]);

}

extern "C"
JNIEXPORT void JNICALL
Java_com_test_updatelibrary_TestUpdate_testPatch(JNIEnv *env, jclass type, jstring oldApk_,
                                                 jstring outApk_, jstring patch_) {
    const char *oldApk = env->GetStringUTFChars(oldApk_, 0);
    const char *outApk = env->GetStringUTFChars(outApk_, 0);
    const char *patch = env->GetStringUTFChars(patch_, 0);

    __android_log_print(ANDROID_LOG_ERROR,"HelloJni","oldfile*%s",oldApk);
    __android_log_print(ANDROID_LOG_ERROR,"HelloJni","oldfile*%s",outApk);
    __android_log_print(ANDROID_LOG_ERROR,"HelloJni","oldfile*%s",patch);


    char * arvg[4] = {"", const_cast<char *>(oldApk), const_cast<char *>(outApk),
                      const_cast<char *>(patch)};
    int i = bsPatch_main(4, arvg);
    __android_log_print(ANDROID_LOG_ERROR,"HelloJni","oldfile*%i",i);

    env->ReleaseStringUTFChars(oldApk_, oldApk);
    env->ReleaseStringUTFChars(outApk_, outApk);
    env->ReleaseStringUTFChars(patch_, patch);
}

extern "C"
JNIEXPORT void JNICALL
Java_com_test_updatelibrary_TestUpdate_testDiff(JNIEnv *env, jclass type, jstring oldApk_,
                                                jstring outApk_, jstring patch_) {
    const char *oldApk = env->GetStringUTFChars(oldApk_, 0);
    const char *outApk = env->GetStringUTFChars(outApk_, 0);
    const char *patch = env->GetStringUTFChars(patch_, 0);

    char * arvg[4] = {"", const_cast<char *>(oldApk), const_cast<char *>(outApk),
                      const_cast<char *>(patch)};
    int i = bsdiff_main(4, arvg);

    __android_log_print(ANDROID_LOG_ERROR,"HelloJni","oldfile*%i",i);

    env->ReleaseStringUTFChars(oldApk_, oldApk);
    env->ReleaseStringUTFChars(outApk_, outApk);
    env->ReleaseStringUTFChars(patch_, patch);
}