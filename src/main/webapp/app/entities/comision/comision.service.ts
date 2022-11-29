import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IComision } from 'app/shared/model/comision.model';

type EntityResponseType = HttpResponse<IComision>;
type EntityArrayResponseType = HttpResponse<IComision[]>;

@Injectable({ providedIn: 'root' })
export class ComisionService {
  public resourceUrl = SERVER_API_URL + 'api/comisions';

  constructor(protected http: HttpClient) {}

  create(comision: IComision): Observable<EntityResponseType> {
    return this.http.post<IComision>(this.resourceUrl, comision, { observe: 'response' });
  }

  update(comision: IComision): Observable<EntityResponseType> {
    return this.http.put<IComision>(this.resourceUrl, comision, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IComision>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IComision[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<any>> {
    return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
