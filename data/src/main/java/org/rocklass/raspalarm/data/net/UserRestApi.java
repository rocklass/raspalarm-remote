package org.rocklass.raspalarm.data.net;

import org.rocklass.raspalarm.data.entity.UserEntity;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

/**
 * RestApi for retrieving data from the network.
 */
public interface UserRestApi {
    /**
     * Api url for getting all users
     */
    String API_URL_GET_USER_LIST = "users.json";
    /**
     * Api url for getting a user profile'
     */
    String API_URL_GET_USER_DETAILS = "user_{userId}.json";

    /**
     * Retrieves a {@link Call} which will emit a List of {@link UserEntity}.
     */
    @GET (API_URL_GET_USER_LIST)
    Observable<List<UserEntity>> userEntityList();

    /**
     * Retrieves a {@link Call} which will emit a {@link UserEntity}.
     *
     * @param userId The user id used to get user data.
     */
    @GET (API_URL_GET_USER_DETAILS)
    Observable<UserEntity> userEntityById(final @Path("userId") int userId);
}
