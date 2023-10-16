# DoggieApi - RESTful API Documentation

This document provides an overview of the endpoints available in the DoggieApi application and the expected request and response formats.

## Endpoints


### Dogs

#### Get All Dogs

- **URL:** `/dogs`
- **Method:** GET
- **Description:** Retrieve a list of all dogs.
- **Sample Response:**
  ```json
  [
      {
          "id": 1,
          "name": "DogName1",
          "race": "Breed1",
          "age": 3,
          "color": "color1",
          "owner": {} // Owner information
      },
      {
          "id": 2,
          "name": "DogName2",
          "race": "Breed2",
          "age": 2,
          "color": "color2",
          "owner": {} // Owner information
      }
  ]
  ```

#### Get Dog by ID

- **URL:** `/dogs/{id}`
- **Method:** GET
- **Description:** Retrieve a dog by its ID.
- **Sample Response:**
  ```json
  {
      "id": 1,
      "name": "DogName1",
      "race": "Breed1",
      "age": 3,
      "color": "color1",
      "owner": {} // Owner information
  }
  ```

#### Create a New Dog

- **URL:** `/dogs`
- **Method:** POST
- **Description:** Create a new dog.
- **Sample Request:**
  ```json
  {
      "name": "NewDogName",
      "race": "NewBreed",
      "age": 4,
      "color": "NewColor",
  }
  ```
- **Sample Response:**
  ```json
  {
      "id": 3,
      "name": "NewDogName",
      "race": "NewBreed",
      "age": 4,
      "color": "NewColor",
  }
  ```

#### Update Dog

- **URL:** `/dogs/{id}`
- **Method:** PUT
- **Description:** Update an existing dog.
- **Sample Request:**
  ```json
  {
      "name": "UpdatedDogName",
      "age": 5,
      "color": "UpdatedColor",
  }
  ```
- **Sample Response:**
  ```json
  {
      "id": 1,
      "name": "UpdatedDogName",
      "race": "Race",
      "age": 5,
      "color": "UpdatedColor",
  }
  ```

#### Delete Dog

- **URL:** `/dogs/{id}`
- **Method:** DELETE
- **Description:** Delete a dog by its ID.
- **Sample Response:** `204 No Content`


### Owners

#### Get All Owners

- **URL:** `/owners`
- **Method:** GET
- **Description:** Retrieve a list of all owners.
- **Sample Response:**
  ```json
  [
      {
          "id": 1,
          "name": "OwnerName1",
          "dog": {} // Dog information
      },
      {
          "id": 2,
          "name": "OwnerName2",
          "dog": {} // Dog information
      }
  ]
  ```

#### Get Owner by ID

- **URL:** `/owners/{id}`
- **Method:** GET
- **Description:** Retrieve an owner by their ID.
- **Sample Response:**
  ```json
  {
      "id": 1,
      "name": "OwnerName1",
      "dog": {} // Dog information
  }
  ```

#### Create a New Owner

- **URL:** `/owners`
- **Method:** POST
- **Description:** Create a new owner.
- **Sample Request:**
  ```json
  {
      "name": "NewOwnerName",
  }
  ```
- **Sample Response:**
  ```json
  {
      "id": 3,
      "name": "NewOwnerName",
  }
  ```

#### Update Owner

- **URL:** `/owners/{id}`
- **Method:** PUT
- **Description:** Update an existing owner.
- **Sample Request:**
  ```json
  {
      "name": "UpdatedOwnerName",
      "dog": {} // Dog information
  }
  ```
- **Sample Response:**
  ```json
  {
      "id": 1,
      "name": "UpdatedOwnerName",
      "dog": {} // Dog information
  }
  ```

#### Delete Owner

- **URL:** `/owners/{id}`
- **Method:** DELETE
- **Description:** Delete an owner by their ID.
- **Sample Response:** `204 No Content`

### Walks

#### Get All Walks

- **URL:** `/walks`
- **Method:** GET
- **Description:** Retrieve a list of all walks.
- **Sample Response:**
  ```json
  [
      {
          "id": 1,
          "location": "Park",
          "dateTime": "2023-10-15T12:00:00",
          "dogId": 1,
          "ownerId": 1
      },
      {
          "id": 2,
          "location": "Beach",
          "dateTime": "2023-10-16T14:30:00",
          "dogId": 2,
          "ownerId": 2
      }
  ]
  ```

#### Create a New Walk

- **URL:** `/walks`
- **Method:** POST
- **Description:** Create a new walk.
- **Sample Request:**
  ```json
  {
      "location": "NewWalkLocation",
      "dateTime": "2023-10-17T10:15:00",
      "dogId": 3,
      "ownerId": 3
  }
  ```
- **Sample Response:**
  ```json
  {
      "id": 3,
      "location": "NewWalkLocation",
      "dateTime": "2023-10-17T10:15:00",
      "dogId": 3,
      "ownerId": 3
  }
  ```

#### Update Walk

- **URL:** `/walks/{id}`
- **Method:** PUT
- **Description:** Update an existing walk.
- **Sample Request:**
  ```json
  {
      "location": "UpdatedWalkLocation",
      "dateTime": "2023-10-18T16:45:00",
      "dogId": 2,
      "ownerId": 1
  }
  ```
- **Sample Response:**
  ```json
  {
      "id": 1,
      "location": "UpdatedWalkLocation",
      "dateTime": "2023-10-18T16:45:00",
      "dogId": 2,
      "ownerId": 1
  }
  ```

#### Delete Walk

- **URL:** `/walks/{id}`
- **Method:** DELETE
- **Description:** Delete a walk by its ID.
- **Sample Response:** `204 No Content`
