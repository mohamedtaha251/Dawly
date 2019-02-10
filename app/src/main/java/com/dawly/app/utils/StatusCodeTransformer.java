package com.dawly.app.utils;//package com.dsquares.lucky.utils;
//
//import io.reactivex.Observable;
//import retrofit2.Response;
//
//public class StatusCodeTransformer <T> implements Observable<Response<T>, T> {
//
//        @Override
////        public Observable<T> call(Observable<Response<T>> responseObservable) {
////            return responseObservable.flatMap(new Func1<Response<T>, Observable<T>>() {
////                @Override
////                public Observable<T> call(Response<T> loginResponse) {
////                    switch (loginResponse.code()) {
////                        case 200:
////                            return Observable.just(loginResponse.body());
////                        case 202:
////                            //need to Repeat
////                            return Observable.error(new Status202Exception());
////                        default:
////                            return Observable.error(new Exception("unknown error"));
////                    }
////                }
////            });
////
////        }
////    }?
//}
