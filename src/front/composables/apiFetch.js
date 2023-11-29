export const apiFetch = (url, options = {}) => {
  const config = useRuntimeConfig()

  return $fetch(`http://localhost:8080${url}`, {
    ...options,
    async onResponseError({ request, response, optionsError }) {

      if (options.onResponseError) {
        options.onResponseError({ request, response, optionsError })
      }
    },
    async onResponse({ request, response, options }) {
      response._data = {
        data: response._data,
        status: response.status
      }
    },
  })
}
