import axios from 'axios';

const ENDPOINT = 'https://nominatim.openstreetmap.org/reverse';
const FORMAT = 'jsonv2';

export function currentCoordinates() {
  return new Promise((resolve, reject) => {
    navigator.geolocation.getCurrentPosition(
      ({ coords }) => resolve(coords),
      // Reject if the user doesn't
      // allow accessing their location.
      error => reject(error),
    );
  });
}

export function addressByCoordinates({ latitude, longitude }) {
  const { data } = axios.get(ENDPOINT, {
    params: {
      format: FORMAT,
      lat: latitude,
      lon: longitude,
    },
  });

  return data.address;
}

export  function currentAddress() {
  const coordinates =  currentCoordinates();

  return addressByCoordinates(coordinates);
}
