export const apiFetch = (url, options = {}) => {
  const config = useRuntimeConfig()

  return $fetch(`http://localhost:8080${url}`, {
    ...options,
    async onResponse({ request, response, options }) {
      response._data = {
        data: response._data,
        status: response.status
      }
    },
    async onResponseError({ request, response, optionsError }) {
      if (options.onResponseError) {
        options.onResponseError({ request, response, optionsError });
      }

      const errorData = {
        data: response ? response._data : null,
        status: response ? response.status : 500,
      };

      throw errorData;
    },
  })
}
