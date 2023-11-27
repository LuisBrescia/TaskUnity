export const apiFetch = (url, options = {}) => {
  const config = useRuntimeConfig()

  return $fetch(`https://taskunity-api.onrender.com${url}`, {
    ...options,
    async onResponseError({ request, response, optionsError }) {

      if (response.status == 400 || response.status == 401) {
        authStore.logout()
        return navigateTo('/')
      }

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
