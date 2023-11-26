<template>
    <div class="form__group field mb-3">
        <input :type="type" class="form__field py-2" placeholder="&nbsp;" :name="value" required>
        <!-- <hr class="linha-horizontal"> -->
        <label :for="value" class="form__label">{{ value  }}</label>
    </div>
</template>

<script setup>
    const props = defineProps({
        value: {
            type: String,
            required: true
        },
        type: {
            type: String,
            default: 'text'
        }
    });
</script>

<style scoped>

.linha-horizontal {
  width: 100%;
  height: 1px;
  border: none;
  background: linear-gradient(90deg, #bbb5, #eee, #bbb5);
  background-size: 200%;
  animation: move-background 3s linear infinite;
  opacity: 1;
}

.form__field,
.form__field:focus~.form__label,
.form__label {
  transition: all 0.5s cubic-bezier(0.175, 0.885, 0.32, 1.275);
}

.form__group {
  position: relative;
  padding: 20px 0 0;
  width: 100%;
}

.form__field:focus .linha-horizontal {
  display: none;
}

.form__group .linha-horizontal {
  position: absolute;
  top: 71%;
  z-index: 3;
}

.form__field {
  font-family: inherit;
  width: 100%;
  border: none;
  border-bottom: 2px solid transparent;
  outline: 0;
  font-weight: 700;
  font-size: 1rem;
  background: transparent;
  color: #fff;
  z-index: 4;
}

.form__field::placeholder {
  color: transparent;
}

.form__field:placeholder-shown~.form__label {
  font-size: 1rem;
  cursor: text;
  top: 20px;
}

.form__field:focus {
  padding-bottom: 6px;
  border-width: 2px;
  border-image: linear-gradient(to right, #38bdf8, #4ade80, #fbbf24, #fb7185);
  border-image-slice: 1;
}

.form__field:focus~.form__label {
  position: absolute;
  top: -1px;
  display: block;
  font-size: 1rem;
  background: linear-gradient(to right, #38bdf8, #4ade80, #fbbf24, #fb7185, #fbbf24, #4ade80, #38bdf8);
  background-clip: text;
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  -moz-background-clip: text;
  width: fit-content;
  white-space: nowrap;
  background-size: 200%;
  animation: move-background 3s linear infinite;
}

.form__field:required,
.form__field:invalid {
  box-shadow: none;
}

.form__label {
  position: absolute;
  top: -1px;
  display: block;
  font-size: 1rem;
  pointer-events: none;
  background: linear-gradient(90deg, #eee 80%, #bbb5 90%, #eee);
  background-clip: text;
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  -moz-background-clip: text;
  width: fit-content;
  white-space: nowrap;
  background-size: 200%;
  animation: move-background 3s linear infinite;
  color: #eee;
}

.form__group:nth-of-type(3) .linha-horizontal {
  animation-delay: -50ms;
}

.form__group:nth-of-type(4) .linha-horizontal {
  animation-delay: -100ms;
}

.form__group:nth-of-type(5) .linha-horizontal {
  animation-delay: -150ms;
}

.form__group input:focus+.linha-horizontal {
  opacity: 0;
}

</style>