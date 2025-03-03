import { HttpInterceptorFn } from '@angular/common/http';
import { AuthStorageService } from './auth-storage.service';
import { inject } from '@angular/core';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
  const authStorageService = inject(AuthStorageService);
  const token = authStorageService.getToken();

  if (token) {
    const clonedReq = req.clone({
      headers: req.headers.set('Authorization', `Bearer ${token}`),
    });
    return next(clonedReq);
  }

  return next(req);
};
